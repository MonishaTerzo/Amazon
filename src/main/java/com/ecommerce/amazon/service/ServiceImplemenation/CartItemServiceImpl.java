package com.ecommerce.amazon.service.ServiceImplemenation;

import com.ecommerce.amazon.dto.CartItemsDto;
import com.ecommerce.amazon.model.Cart;
import com.ecommerce.amazon.model.CartItems;
import com.ecommerce.amazon.repository.CartItemsRepository;
import com.ecommerce.amazon.repository.CartRepository;
import com.ecommerce.amazon.repository.ProductRepository;
import com.ecommerce.amazon.repository.UserRepository;
import com.ecommerce.amazon.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemsRepository cartItemsRepository;
    private final CartRepository cartRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    public CartItemServiceImpl(CartItemsRepository cartItemsRepository, CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartItemsRepository = cartItemsRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }



    @Override
    public void save(CartItemsDto cartItems, Long userId) {
        Cart cart = cartRepository.findByUser(userRepository.findById(userId).get());
        CartItems cartItems1 = new CartItems();
        cartItems1.setProduct(productRepository.findById(cartItems.getProductId()).get());
        cartItems1.setQuantity(cartItems.getQuantity());
        cartItemsRepository.save(cartItems1);
        List<CartItems> cartItemsList = cart.getCartItems();
        cartItemsList.add(cartItems1);
        cart.setCartItems(cartItemsList);
        cartRepository.save(cart);
    }
}
