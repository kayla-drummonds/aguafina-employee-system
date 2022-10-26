package com.michaeladrummonds.aguafina.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.Customer;
import com.michaeladrummonds.aguafina.models.Employee;
import com.michaeladrummonds.aguafina.models.Order;

@Component
public interface OrderService {
    List<Order> getAllOrders();

    Order saveOrder(Order order);

    void deleteOrderById(Long id);

    List<Order> getOrderByCustomerId(Long id, Customer customer);

    List<Order> getOrderByEmployeeId(Long id, Employee employee);
}
