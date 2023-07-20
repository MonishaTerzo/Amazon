package com.ecommerce.amazon.repository;

import com.ecommerce.amazon.model.Order;
import com.ecommerce.amazon.model.User;
import jakarta.persistence.JoinColumn;
import org.hibernate.mapping.Join;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

   @Query("select i from Order i where i.user=:user and i.isDelivered=true")
   List<Order> findByUserAndIsDeliveredTrue(User user);


   @Query("SELECT DISTINCT o FROM Order o " +
           "JOIN o.product p " +
           "JOIN p.category c " +
           "WHERE c.id IN (" +
           "    SELECT DISTINCT c2.id " +
           "    FROM Cart_Item cart " +
           "    JOIN cart.product cart_product " +
           "    JOIN cart_product.category c2 " +
           "    WHERE cart.user.id = :user_id" +
           ")")
   List<Order> findRecommendedOrdersByUserId(Long user_id);



}
