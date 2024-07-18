package com.prod.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prod.entities.Product;
import com.prod.exception.ResourceNotFoundException;
import com.prod.repository.ProductRepository;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addNewProduct(Product newproduct) {
	
		return productRepository.save(newproduct);
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> o= productRepository.findById(id);
		return o.orElseThrow(()->new ResourceNotFoundException("invalid product id !!"));
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product updateProductDetails(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Product removeProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return product.get();
        } else {
            throw new ResourceNotFoundException("Invalid product id !!");
        }
    }

	}

	

	

