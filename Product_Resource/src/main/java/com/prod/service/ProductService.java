package com.prod.service;

import java.util.List;
import java.util.Optional;

import com.prod.entities.Product;

public interface ProductService {
Product addNewProduct(Product newproduct);

Product getProductById(Long id);

List<Product> getAllProduct();

Product updateProductDetails(Product product);

Product removeProduct(Long id);


}
