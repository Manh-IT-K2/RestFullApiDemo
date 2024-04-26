package com.example.Demo.Service.Category;

import com.example.Demo.Model.Category;
import com.example.Demo.Repository.CategoryRepository;
import com.example.Demo.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public ApiResponse<Category> addCategory(Category category) {
        if (!category.getName().isEmpty() && !category.getDescription().isEmpty()) {
            Category resultCategory = categoryRepository.save(category);
            return new ApiResponse<>(true, "Add Success", resultCategory);
        }
        return new ApiResponse<>(false, "Fail Add", null);
    }

    @Override
    public ApiResponse<Category> updateCategory(Category category) {
        if(category.getId() <= 0) {
            return new ApiResponse<>(false, "Invalid category ID", null);
        }

        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if(optionalCategory.isEmpty()) {
            return new ApiResponse<>(false, "Category not found", null);
        }

        Category existingCategory = optionalCategory.get();
        // Cập nhật thông tin của danh mục chỉ khi có dữ liệu mới được cung cấp
        if(!category.getName().isEmpty()) {
            existingCategory.setName(category.getName());
        }
        if(!category.getDescription().isEmpty()) {
            existingCategory.setDescription(category.getDescription());
        }
        if(category.getParentId() != null) {
            existingCategory.setParentId(category.getParentId());
        }

        // Lưu danh mục đã cập nhật vào cơ sở dữ liệu
        Category updatedCategory = categoryRepository.save(existingCategory);
        return new ApiResponse<>(true, "Update Success", updatedCategory);
    }

    @Override
    public ApiResponse<List<Category>> getAllCategory() {
        List<Category> categoryArrayList = categoryRepository.findAll();
        return !categoryArrayList.isEmpty() ?  new ApiResponse<>(true,"Get Success",categoryArrayList) :
                new ApiResponse<>(false,"Empty",null);
    }

    @Override
    public ApiResponse<String> deleteCategory(Category category) {
        if (category.getId() > 0) {
            categoryRepository.delete(category);
            return new ApiResponse<>(true,"Delete Success","Success");
        }
        return new ApiResponse<>(false,"IdCategory Not Exits","Error");
    }
}
