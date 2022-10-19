package com.michaeladrummonds.aguafina.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.OrderDetails;

@Component
public interface OrderDetailsService {

    List<OrderDetails> getAllOrderDetails();

    OrderDetails saveOrderDetails(OrderDetails orderDetails);

    OrderDetails getOrderDetailsById(Long id);

    void deleteOrderDetailsById(Long id);

}
