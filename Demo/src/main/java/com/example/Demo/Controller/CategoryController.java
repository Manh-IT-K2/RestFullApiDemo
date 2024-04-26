package com.example.Demo.Controller;

import com.example.Demo.Model.Category;
import com.example.Demo.Response.ApiResponse;
import com.example.Demo.Service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
        try{
            ApiResponse<List<Category>> result = categoryService.getAllCategory();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    };
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Category category){
        try{
            ApiResponse<Category> result = categoryService.addCategory(category);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    };
    @PostMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        try{
            ApiResponse<Category> result = categoryService.updateCategory(category);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    };
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategory(@RequestParam Long id){
        try{
            Category category = new Category();
            System.err.println(id);
            category.setId(id);
            ApiResponse<String> result = categoryService.deleteCategory(category);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    };
}
