package com.example.Demo.Controller;

import com.example.Demo.Model.Products;
import com.example.Demo.Service.Products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/products")
@RestController
public class ProductsController {

    //
    @Autowired
    private ProductsService productsService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Products products){
        try{
            Products result = productsService.addProduct(products);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    };
}
