package com.aguafina.springboot.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aguafina.springboot.models.Order;
import com.aguafina.springboot.repository.OrderRepository;
import com.aguafina.springboot.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

}
