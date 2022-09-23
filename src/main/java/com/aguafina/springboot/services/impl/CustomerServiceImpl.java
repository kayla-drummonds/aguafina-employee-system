package com.aguafina.springboot.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aguafina.springboot.models.Customer;
import com.aguafina.springboot.repository.CustomerRepository;
import com.aguafina.springboot.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
