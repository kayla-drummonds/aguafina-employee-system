package com.aguafina.springboot.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aguafina.springboot.models.Product;
import com.aguafina.springboot.repository.ProductRepository;
import com.aguafina.springboot.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}