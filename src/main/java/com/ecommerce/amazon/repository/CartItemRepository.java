package com.ecommerce.amazon.repository;

import com.ecommerce.amazon.model.Cart_Item;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<Cart_Item, Long> {
    List<Cart_Item> findByUser(User user);

    @Query("SELECT c FROM Cart_Item c where c.user=:user and c.product=:product")
    Cart_Item findByUserAndproductId(User user, Product product);
}
