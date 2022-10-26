package com.michaeladrummonds.aguafina.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaeladrummonds.aguafina.models.Employee;
import com.michaeladrummonds.aguafina.models.Order;
import com.michaeladrummonds.aguafina.services.impl.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class RestOrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/employee/{employee}")
    public List<Order> getOrderByEmployeeId(@PathVariable("employee") Employee employee, Long id) {
        return orderService.getOrderByEmployeeId(id, employee);
    }

}
