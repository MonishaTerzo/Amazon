package com.ecommerce.amazon.service;

import com.ecommerce.amazon.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsByCategory(String categoryname);
Product saveProduct(Product product);
}
