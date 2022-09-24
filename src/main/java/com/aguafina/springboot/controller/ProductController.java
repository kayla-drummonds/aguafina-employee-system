package com.aguafina.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aguafina.springboot.models.Product;
import com.aguafina.springboot.services.impl.ProductServiceImpl;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/new")
    public String createNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "create_product";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit_product";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product, Model model) {
        Product existingProduct = productService.getProductById(id);
        existingProduct.setId(product.getId());
        existingProduct.setCode(product.getCode());
        existingProduct.setVariety(product.getVariety());
        existingProduct.setSize(product.getSize());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStatus(product.getStatus());
        existingProduct.setImage(product.getImage());

        productService.updateProduct(existingProduct);
        return "redirect:/products";
    }
}
