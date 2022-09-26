package com.michaeladrummonds.aguafina.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.michaeladrummonds.aguafina.models.Order;
import com.michaeladrummonds.aguafina.repository.OrderRepository;
import com.michaeladrummonds.aguafina.services.OrderService;

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
