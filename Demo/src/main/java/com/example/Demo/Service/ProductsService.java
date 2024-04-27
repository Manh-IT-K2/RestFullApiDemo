package com.example.Demo.Service;

import com.example.Demo.Model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {

    // add product
    Products addProduct(Products products);

    // update product
    void updateProduct(Products products);

    // delete product
    void deleteProduct(long id);
    List<Products> findProductByName(String name_product, int limit);
}
