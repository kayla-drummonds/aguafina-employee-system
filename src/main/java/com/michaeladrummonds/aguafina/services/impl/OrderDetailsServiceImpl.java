package com.michaeladrummonds.aguafina.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.michaeladrummonds.aguafina.models.OrderDetails;
import com.michaeladrummonds.aguafina.repository.OrderDetailsRepository;
import com.michaeladrummonds.aguafina.services.OrderDetailsService;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void deleteOrderDetailsById(Integer id) {
        orderDetailsRepository.deleteById(id);
    }

    @Override
    public OrderDetails getOrderDetailsById(Integer id) {
        return orderDetailsRepository.findById(id).get();
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

}
