package com.aguafina.springboot.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aguafina.springboot.models.Order;

@Component
public interface OrderService {
    List<Order> getAllCustomerOrders();
}
