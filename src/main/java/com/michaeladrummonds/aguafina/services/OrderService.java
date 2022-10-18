package com.michaeladrummonds.aguafina.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.Customer;
import com.michaeladrummonds.aguafina.models.OrderDetails;

@Component
public interface OrderService {
    List<OrderDetails> getAllOrders();

    OrderDetails saveOrder(OrderDetails order);

    void deleteOrderById(Long id);

    List<OrderDetails> getOrderByCustomerId(Long id, Customer customer);
}
