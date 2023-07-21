package com.ecommerce.amazon.repository;

import com.ecommerce.amazon.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

}
