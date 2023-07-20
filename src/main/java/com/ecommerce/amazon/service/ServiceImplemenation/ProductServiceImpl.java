package com.ecommerce.amazon.service.ServiceImplemenation;

import com.ecommerce.amazon.model.Category;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.repository.CategoryRepository;
import com.ecommerce.amazon.repository.ProductRepository;
import com.ecommerce.amazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

        @Autowired
        public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository) {
            this.productRepository = productRepository;
            this.categoryRepository=categoryRepository;
        }

        public List<Product> getProductsByCategory(String categoryname) {
            Category category = categoryRepository.findByName(categoryname);
            return productRepository.findByCategory(category);
        }
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    }


