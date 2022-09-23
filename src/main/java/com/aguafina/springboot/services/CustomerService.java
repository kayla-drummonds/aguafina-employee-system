package com.aguafina.springboot.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aguafina.springboot.models.Customer;

@Component
public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    Customer saveCustomer(Customer customer);
}
