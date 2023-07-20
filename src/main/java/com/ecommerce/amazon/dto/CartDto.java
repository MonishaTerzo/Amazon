package com.ecommerce.amazon.dto;

import lombok.Data;

@Data
public class CartDto {
    private int quantity;
    private Long productId;
}
