package com.aguafina.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aguafina.springboot.models.Customer;
import com.aguafina.springboot.models.Employee;
import com.aguafina.springboot.models.Order;
import com.aguafina.springboot.models.Product;
import com.aguafina.springboot.services.impl.CustomerServiceImpl;
import com.aguafina.springboot.services.impl.EmployeeServiceImpl;
import com.aguafina.springboot.services.impl.OrderServiceImpl;
import com.aguafina.springboot.services.impl.ProductServiceImpl;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/orders")
    public String listAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/orders/new")
    public String createOrder(Model model) {
        Order order = new Order();
        List<Product> products = productService.getAllProducts();
        List<Customer> customers = customerService.getAllCustomers();
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("order", order);
        model.addAttribute("products", products);
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        return "create_order";
    }

    @PostMapping("/orders")
    public String saveOrder(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
}
