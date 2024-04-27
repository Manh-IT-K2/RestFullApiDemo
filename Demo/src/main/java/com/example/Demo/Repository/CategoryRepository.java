package com.example.Demo.Repository;

import com.example.Demo.Modal.Category;
import com.example.Demo.Response.Category.ResponseGetProductByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT pd.name_product AS name, pd.price AS price, pd.description AS description, " +
            "cate.name AS nameCategory " +
            "FROM products AS pd " +
            "JOIN category AS cate ON pd.category_id = cate.id", nativeQuery = true)
    List<ResponseGetProductByCategory> getProductByCategory();
}
