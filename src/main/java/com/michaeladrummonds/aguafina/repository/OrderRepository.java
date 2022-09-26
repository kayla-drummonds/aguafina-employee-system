package com.aguafina.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aguafina.springboot.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
