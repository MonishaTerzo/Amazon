package com.ecommerce.amazon.service;

import com.ecommerce.amazon.dto.CartDto;
import com.ecommerce.amazon.model.Product;

import java.util.List;

public interface CartItemService {
    CartDto addItemToCart(CartDto cartItemDTO, Long userId);
    List<Product> getProductFromCart(Long id);
}
