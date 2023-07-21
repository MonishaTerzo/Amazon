package com.ecommerce.amazon.repository;

import com.ecommerce.amazon.model.Cart;
import com.ecommerce.amazon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);



//    @Query("SELECT c FROM Cart c where c.user=:user and c.product=:product")
//    Cart findByUserAndproductId(User user, Product product);
}
