package com.michaeladrummonds.aguafina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.michaeladrummonds.aguafina.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.status = ?1")
    List<Product> getProductByStatus(String status);
}
