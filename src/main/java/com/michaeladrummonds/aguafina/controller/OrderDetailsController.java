package com.michaeladrummonds.aguafina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeladrummonds.aguafina.models.OrderDetails;
import com.michaeladrummonds.aguafina.models.Product;
import com.michaeladrummonds.aguafina.services.impl.OrderDetailsServiceImpl;
import com.michaeladrummonds.aguafina.services.impl.ProductServiceImpl;

@Controller
@RequestMapping
public class OrderDetailsController {

    @Autowired
    private OrderDetailsServiceImpl orderDetailsService;

    @Autowired
    private ProductServiceImpl productService;

    // displays form to create a new OrderDetails object
    // and populates the products list
    @GetMapping("/orderdetails/new")
    public String createOrderDetails(Model model) {
        OrderDetails orderDetails = new OrderDetails();
        List<Product> products = productService.getAllProducts();
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("products", products);
        return "create_order_details";
    }

    // saves the new OrderDetails object, shows the
    // OrderDetails id to create a new Order object,
    // and gives the option to create another OrderDetails object
    @PostMapping("/orderdetails/save")
    public String saveOrderDetails(@ModelAttribute("orderDetails") OrderDetails orderDetails, Model model) {
        orderDetailsService.saveOrderDetails(orderDetails);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("products", products);
        return "save_order_details";
    }
}
