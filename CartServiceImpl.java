package com.ecommerce.amazon.service.ServiceImplemenation;

import com.ecommerce.amazon.dto.CartDto;
import com.ecommerce.amazon.dto.CartItemsDto;
import com.ecommerce.amazon.model.Cart;
import com.ecommerce.amazon.model.CartItems;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.repository.CartRepository;
import com.ecommerce.amazon.repository.ProductRepository;
import com.ecommerce.amazon.repository.UserRepository;
import com.ecommerce.amazon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(
            CartRepository cartItemRepository,
            UserRepository userRepository,
            ProductRepository productRepository
    ) {
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartDto addItemToCart(CartItemsDto cartItemDTO, Long userId) {
        Cart cart =new Cart();
        List<CartItems> carts = cart.getCartItems();
        carts.add(mapT0CatItem(cartItemDTO));
        cart.setUser(userRepository.findById(userId).get());
        cart.setOrdered(false);
        cartItemRepository.save(cart);
        return null;
    }

    private CartItems mapT0CatItem(CartItemsDto cartItemDTO) {
        return CartItems.builder()
                .product(productRepository.findById(cartItemDTO.getProductId()).get())
                .quantity(cartItemDTO.getQuantity())
                .build();
    }

    @Override
    public List<Product> getProductFromCart(Long id) {
//        List<Cart> cartItems = cartItemRepository.findByUser(userRepository.findById(id).get());
        return null;
    }

    private List<Product> mapToProductList(List<Cart> cartItems) {
//        return cartItems.stream()
//                .map(x->x.getProduct())
//                .collect(Collectors.toList());
    return null;
    }

    private CartDto convertToDTO(Cart cartItem) {
        CartDto cartItemDTO = new CartDto();
//        cartItemDTO.setQuantity(cartItem.getQuantity());
//        cartItemDTO.setProductId(cartItem.getProduct().getId());
        return cartItemDTO;
    }
}
