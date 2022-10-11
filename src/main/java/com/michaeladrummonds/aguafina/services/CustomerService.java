package com.michaeladrummonds.aguafina.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.michaeladrummonds.aguafina.models.Customer;

@Component
public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer getCustomerById(Long id);
}
