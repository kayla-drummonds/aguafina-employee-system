package com.michaeladrummonds.aguafina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeladrummonds.aguafina.models.Product;
import com.michaeladrummonds.aguafina.services.impl.ProductServiceImpl;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/new")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "create_product";
    }

    @PostMapping("/products")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit_product";
    }

    @PostMapping("/products/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute("product") Product product, Model model) {
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

    @GetMapping("/products/{status}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getProductsByStatus(Model model, @Param("status") String status, Product product) {
        List<Product> productsByStatus = productService.getProductByStatus(product.getStatus());
        model.addAttribute("productsByStatus", productsByStatus);
        model.addAttribute("status", status);
        return "status_products";
    }
}
