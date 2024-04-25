package com.example.Demo.Repository;

import com.example.Demo.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {


}
