package com.example.Demo.Service.Products;

import com.example.Demo.Model.Products;
import org.springframework.stereotype.Service;

@Service
public interface ProductsService {

    // add product
    Products addProduct(Products products);

    // update product
    void updateProduct(Products products);

    // delete product
    void deleteProduct(long id);
}
