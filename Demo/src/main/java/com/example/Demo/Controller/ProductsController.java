package com.example.Demo.Controller;

import com.example.Demo.Modal.Products;
import com.example.Demo.Service.Products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // update product
    @PostMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Products products){
        try{
            productsService.updateProduct(products);
            return ResponseEntity.status(HttpStatus.OK).body("Update success!");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    };

    // delete product
    @PostMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestParam long id){
        try{
            productsService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    };

    // find product
    @GetMapping("/findProductByName")
    public ResponseEntity<?> findProductByName(@RequestParam String name_product, @RequestParam int limit) {
        try {
            if (name_product.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("userId is required");
            }
            List<Products> result = productsService.findProductByName(name_product,limit);
            return result == null ? ResponseEntity.status(HttpStatus.OK).body("No data") : ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }
}
