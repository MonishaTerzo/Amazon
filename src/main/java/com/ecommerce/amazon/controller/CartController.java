package com.ecommerce.amazon.controller;

import com.ecommerce.amazon.dto.CartDto;
import com.ecommerce.amazon.model.Category;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.service.CartItemService;
import com.ecommerce.amazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CartController {

    private final CartItemService cartItemService;
    private final ProductService productService;

    @Autowired
    public CartController(CartItemService cartItemService, ProductService productService) {
        this.cartItemService = cartItemService;
        this.productService = productService;
    }


    @PostMapping("AddToCart/{userId}")
    public ResponseEntity<CartDto> addItemToCart(@RequestBody CartDto cartItemDTO, @PathVariable Long userId) {
        CartDto addedCartItem = cartItemService.addItemToCart(cartItemDTO, userId);
        return new ResponseEntity<>(addedCartItem, HttpStatus.CREATED);
    }



    @GetMapping("/RecommendedProducts/{userId}")
    public List<List<Product>> recommendedProducts(@PathVariable("userId") Long userId) {
        List<Category> categoryList = cartItemService.getProductFromCart(userId).stream()
                .map(x->x.getCategory())
                .collect(Collectors.toList());
        List<List<Product>> products = categoryList.stream()
                .map(x->productService.getProductsByCategory(x.getName()))
                .collect(Collectors.toList());

        return products;
    }

}
