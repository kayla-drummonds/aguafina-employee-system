package com.michaeladrummonds.aguafina.services.impl;

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
    public void deleteOrderDetailsById(Long id) {
        orderDetailsRepository.deleteById(id);
    }

    @Override
    public OrderDetails getOrderDetailsById(Long id) {
        return orderDetailsRepository.findById(id).get();
    }

}
