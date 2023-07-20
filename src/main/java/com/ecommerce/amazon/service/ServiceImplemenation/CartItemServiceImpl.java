package com.ecommerce.amazon.service.ServiceImplemenation;

import com.ecommerce.amazon.dto.CartDto;
import com.ecommerce.amazon.model.Cart_Item;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.model.User;
import com.ecommerce.amazon.repository.CartItemRepository;
import com.ecommerce.amazon.repository.ProductRepository;
import com.ecommerce.amazon.repository.UserRepository;
import com.ecommerce.amazon.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartItemServiceImpl(
            CartItemRepository cartItemRepository,
            UserRepository userRepository,
            ProductRepository productRepository
    ) {
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartDto addItemToCart(CartDto cartItemDTO, Long userId) {
        User user = userRepository.getById(userId);
        Product product = productRepository.getById(cartItemDTO.getProductId());

        Cart_Item cartItem = new Cart_Item();
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setProduct(product);
        cartItem.setUser(user);

        cartItem = cartItemRepository.save(cartItem);

        return convertToDTO(cartItem);
    }

    @Override
    public List<Product> getProductFromCart(Long id) {
        List<Cart_Item> cartItems = cartItemRepository.findByUser(userRepository.findById(id).get());
        return mapToProductList(cartItems);
    }

    private List<Product> mapToProductList(List<Cart_Item> cartItems) {
        return cartItems.stream()
                .map(x->x.getProduct())
                .collect(Collectors.toList());
    }

    private CartDto convertToDTO(Cart_Item cartItem) {
        CartDto cartItemDTO = new CartDto();
        cartItemDTO.setQuantity(cartItem.getQuantity());
        cartItemDTO.setProductId(cartItem.getProduct().getId());
        return cartItemDTO;
    }
}
