package com.ecommerce.amazon.service;

import com.ecommerce.amazon.dto.OrderDto;
import com.ecommerce.amazon.model.Order;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getDeliveredOrdersByUser(User user);
    void createOrder(OrderDto orderDTO);
    List<Product> recommendedProducts(Long id);
}
