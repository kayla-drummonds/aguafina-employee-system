package com.aguafina.springboot.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aguafina.springboot.models.Product;

@Component
public interface ProductService {
    List<Product> getAllProducts();
}
