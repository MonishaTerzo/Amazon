package com.ecommerce.amazon.repository;


import com.ecommerce.amazon.model.Category;
import com.ecommerce.amazon.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ProductRepository extends JpaRepository<Product, Long> {
        List<Product> findByCategory(Category category);
    }


