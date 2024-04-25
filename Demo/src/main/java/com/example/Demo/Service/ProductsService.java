package com.example.Demo.Service;

import com.example.Demo.Model.Products;
import org.springframework.stereotype.Service;

@Service
public interface ProductsService {

    // add product
    Products addProduct(Products products);
}
