package com.aguafina.springboot.services;

import java.util.List;

import com.aguafina.springboot.models.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    Customer saveCustomer(Long id);
}
