package com.aguafina.springboot.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aguafina.springboot.models.CustomerOrder;

@Component
public interface CustomerOrderService {
    List<CustomerOrder> getAllCustomerOrders();
}
