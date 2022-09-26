package com.michaeladrummonds.aguafina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michaeladrummonds.aguafina.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
