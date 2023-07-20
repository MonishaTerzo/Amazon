package com.ecommerce.amazon.controller;

import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/category/{query}")
    public List<Product> getProductsByCategory(@PathVariable String query) {
        return productService.getProductsByCategory(query);
    }

    @PostMapping("/add")
    public Product addEmployee(@RequestBody Product products) {
        Product product = productService.saveProduct(products);
        return product;
    }



}
