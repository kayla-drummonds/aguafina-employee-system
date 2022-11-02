package com.michaeladrummonds.aguafina.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.michaeladrummonds.aguafina.models.Product;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceImplIntegerationTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Order(1)
    public void testGetProductByStatusActive() {
        Product productA = new Product(5, "MWPOM20", "Pomegranate", 20, 2.0, "ACTIVE", "pomegranate.png");
        productRepository.save(productA);
        List<Product> activeProducts = productRepository.getProductByStatus("ACTIVE");
        Assertions.assertEquals(1, activeProducts.size());
        for (Product a : activeProducts) {
            System.out.println(a.getId() + " | " + a.getCode() + " | " + a.getVariety() + " | " + a.getPrice() + " | "
                    + a.getSize() + " | " + a.getStatus());
        }
    }

    @Test
    @Order(2)
    public void testGetProductByStatusDiscontinued() {
        Product productD = new Product(6, "MWPOM32", "Pomegranate", 32, 4.0, "DISCONTINUED", "pomegranate.png");
        productRepository.save(productD);
        List<Product> discontinuedProducts = productRepository.getProductByStatus("DISCONTINUED");
        Assertions.assertEquals(1, discontinuedProducts.size());

        for (Product d : discontinuedProducts) {
            System.out.println(d.getId() + " | " + d.getCode() + " | " + d.getVariety() + " | " + d.getPrice() + " | "
                    + d.getSize() + " | " + d.getStatus());
        }
    }
}
