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
import org.springframework.web.bind.annotation.RequestParam;

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

    // displays all customers
    @GetMapping("/customers")
    public String listCustomers(@ModelAttribute("customer") Customer customer,
            @RequestParam(value = "keyword", required = false) String keyword, Model model) {

        if (keyword != null) {
            List<Customer> customers = customerService.getCustomerByKeyword(keyword);
            model.addAttribute("customers", customers);
            model.addAttribute("keyword", keyword);
        } else {
            List<Customer> customers = customerService.getAllCustomers();
            model.addAttribute("customers", customers);
            model.addAttribute("keyword", keyword);
        }
        return "customers";
    }

    // displays the form to construct a new customer object
    @GetMapping("/customers/new")
    public String createNewCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
    }

    // saves the new customer object and redirects to the customers page
    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    // displays the form to update an existing customer object with a given id
    @GetMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit_customer";
    }

    // edits an existing customer object, saves the updated object, and redirects to
    // the customers page
    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Integer id, @ModelAttribute("customer") Customer customer, Model model) {
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
