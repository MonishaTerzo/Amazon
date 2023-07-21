package com.ecommerce.amazon.service;

import com.ecommerce.amazon.dto.CartDto;
import com.ecommerce.amazon.dto.CartItemsDto;
import com.ecommerce.amazon.model.CartItems;

public interface CartItemService {

    void save(CartItemsDto cartItems, Long userId);
}
