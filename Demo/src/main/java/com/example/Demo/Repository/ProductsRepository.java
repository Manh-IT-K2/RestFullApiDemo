package com.example.Demo.Repository;

import com.example.Demo.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    // create product
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO products (name_product, description, price) VALUES (?1, ?2, ?3)", nativeQuery = true)
    Products createProduct(String name_product, String description, Integer price);

    // update product
    @Modifying
    @Transactional
    @Query(value = "UPDATE products p SET p.name_product = ?1, p.description = ?2, p.price = ?3 WHERE p.id = ?4", nativeQuery = true)
    void updateProduct(String name_product, String description, int price, long id);

    // delete product
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM products WHERE id = ?1", nativeQuery = true)
    void deleteProduct(long id);

    // find
    @Query(value = "SELECT * FROM products WHERE LOWER(name_product) LIKE CONCAT('%', LOWER(?1), '%')  LIMIT ?2", nativeQuery = true)
    List<Products> findProductByName(String name_product,int limit);
}
