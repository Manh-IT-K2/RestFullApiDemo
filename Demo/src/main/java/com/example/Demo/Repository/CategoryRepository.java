package com.example.Demo.Repository;

import com.example.Demo.Model.Category;
import com.example.Demo.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
