package com.example.Demo.Repository;

import com.example.Demo.Modal.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE products p SET p.name_product = ?1, p.description = ?2, p.price = ?3 WHERE p.id = ?4", nativeQuery = true)
    void updateProduct(String name_product, String description, int price, long id);
}
