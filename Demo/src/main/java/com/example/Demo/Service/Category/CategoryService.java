package com.example.Demo.Service.Category;

import com.example.Demo.Model.Category;
import com.example.Demo.Response.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CategoryService {
    public ApiResponse<Category> addCategory (Category category);
    public ApiResponse<Category> updateCategory (Category category);
    public ApiResponse<List<Category>> getAllCategory ();
    public ApiResponse<String> deleteCategory(Category category);
}
