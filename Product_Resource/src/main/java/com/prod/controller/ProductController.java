package com.prod.controller;

import com.prod.entities.Product;
import com.prod.exception.ResourceNotFoundException;
import com.prod.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

   @PostMapping
   public Product addNewProduct(@RequestBody Product newproduct) {
	   return productService.addNewProduct(newproduct);
   }

   @GetMapping("/{id}")
   public Product getProductById(@PathVariable Long id) {
   return productService.getProductById(id);
   
   }
   
   @GetMapping
   public List<Product> getAllProduct(){
	   return productService.getAllProduct();
   }
   
   @PutMapping
   public Product updateProductDetails(@RequestBody Product product) {
return productService.updateProductDetails(product);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<?> removeProduct(@PathVariable Long id) {
       try {
           Product removedProduct = productService.removeProduct(id);
           return new ResponseEntity<>(removedProduct, HttpStatus.OK);
       } catch (ResourceNotFoundException e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
   }
}

