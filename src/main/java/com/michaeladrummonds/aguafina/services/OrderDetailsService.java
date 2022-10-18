package com.michaeladrummonds.aguafina.services;

import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.OrderDetails;

@Component
public interface OrderDetailsService {
    OrderDetails saveOrderDetails(OrderDetails orderDetails);

    void deleteOrderDetailsById(Long id);
}
