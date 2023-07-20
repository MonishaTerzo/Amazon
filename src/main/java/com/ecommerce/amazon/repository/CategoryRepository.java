package com.ecommerce.amazon.repository;

import com.ecommerce.amazon.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

   Category findByName(String categoryname);
}
