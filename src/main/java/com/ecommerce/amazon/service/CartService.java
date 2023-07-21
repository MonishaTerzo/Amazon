package com.ecommerce.amazon.service;

import com.ecommerce.amazon.dto.CartDto;
import com.ecommerce.amazon.dto.CartItemsDto;
import com.ecommerce.amazon.model.CartItems;
import com.ecommerce.amazon.model.Product;

import java.util.Arrays;
import java.util.List;

public interface CartService {

    CartDto addItemToCart(CartItemsDto cartItems, Long userId);

    List<Product> getProductFromCart(Long userId);
}
