package com.michaeladrummonds.aguafina.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.Order;

@Component
public interface OrderService {
    List<Order> getAllOrders();

    Order saveOrder(Order order);
}