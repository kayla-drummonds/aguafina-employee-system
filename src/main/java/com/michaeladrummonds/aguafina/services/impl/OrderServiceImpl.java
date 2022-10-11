package com.michaeladrummonds.aguafina.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.michaeladrummonds.aguafina.models.Order;
import com.michaeladrummonds.aguafina.repository.OrderRepository;
import com.michaeladrummonds.aguafina.services.OrderService;

@Service
@Transactional
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

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

}
