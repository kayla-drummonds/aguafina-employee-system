package com.michaeladrummonds.aguafina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeladrummonds.aguafina.models.Customer;
import com.michaeladrummonds.aguafina.services.impl.CustomerServiceImpl;

@Controller
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createNewCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
    }

    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer, Model model) {
        Customer existingCustomer = customerService.getCustomerById(id);
        existingCustomer.setId(customer.getId());
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setZipCode(customer.getZipCode());

        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";
    }

}
