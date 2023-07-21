package com.ecommerce.amazon.controller;

import com.ecommerce.amazon.dto.CartDto;
import com.ecommerce.amazon.dto.CartItemsDto;
import com.ecommerce.amazon.model.CartItems;
import com.ecommerce.amazon.model.Category;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.service.CartItemService;
import com.ecommerce.amazon.service.CartService;
import com.ecommerce.amazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CartController {

    private final CartService cartItemService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartItemService, ProductService productService) {
        this.cartItemService = cartItemService;
        this.productService = productService;
    }


    @PostMapping("AddToCart/{userId}")
    public boolean addItemToCart(@RequestBody CartItemsDto cartItems, @PathVariable Long userId) {
        CartDto addedCartItem = cartItemService.addItemToCart(cartItems, userId);
        return true;
    }


    @GetMapping("/RecommendedProducts/{userId}")
    public List<List<Product>> recommendedProducts(@PathVariable("userId") Long userId) {
//        List<Category> categoryList = cartItemService.getProductFromCart(userId).stream()
//                .map(x->x.getCategory())
//                .collect(Collectors.toList());
//        List<List<Product>> products = categoryList.stream()
//                .map(x->productService.getProductsByCategory(x.getName()))
//                .collect(Collectors.toList());

        return null;
    }

}
