package com.michaeladrummonds.aguafina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeladrummonds.aguafina.models.Customer;
import com.michaeladrummonds.aguafina.models.Employee;
import com.michaeladrummonds.aguafina.models.Order;
import com.michaeladrummonds.aguafina.models.OrderDetails;
import com.michaeladrummonds.aguafina.services.impl.CustomerServiceImpl;
import com.michaeladrummonds.aguafina.services.impl.EmployeeServiceImpl;
import com.michaeladrummonds.aguafina.services.impl.OrderDetailsServiceImpl;
import com.michaeladrummonds.aguafina.services.impl.OrderServiceImpl;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private OrderDetailsServiceImpl orderDetailsService;

    @GetMapping("/orders")
    public String listAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/orders/new")
    public String createOrder(Model model) {
        Order order = new Order();
        List<OrderDetails> orderDetails = orderDetailsService.getAllOrderDetails();
        List<Customer> customers = customerService.getAllCustomers();
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        return "create_order";
    }

    @PostMapping("/orders")
    public String saveOrder(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders/{id}")
    public String deleteOrderById(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
        return "redirect:/orders";
    }

    @GetMapping("/orders/customer/{customer}")
    public String getOrdersByCustomer(Model model, @Param("customer") Customer customer) {
        Integer customerId = customer.getId();
        List<Order> ordersByCustomer = orderService.getOrderByCustomerId(customerId, customer);
        Double total = orderService.getTotalByCustomerId(customerId, customer);
        model.addAttribute("ordersByCustomer", ordersByCustomer);
        model.addAttribute("customer", customer);
        model.addAttribute("total", total);
        return "customer_orders";
    }

    @GetMapping("/orders/employee/{employee}")
    public String getOrdersByEmployee(Model model, @Param("employee") @ModelAttribute("employee") Employee employee) {
        Integer employeeId = employee.getId();
        List<Order> ordersByEmployee = orderService.getOrderByEmployeeId(employee, employeeId);
        Double orderCount = orderService.countOrdersByEmployeeId(employee, employeeId);
        model.addAttribute("ordersByEmployee", ordersByEmployee);
        model.addAttribute("orderCount", orderCount);
        return "employee_orders";
    }
}
