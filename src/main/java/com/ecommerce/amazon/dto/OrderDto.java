package com.ecommerce.amazon.dto;

import com.ecommerce.amazon.model.Category;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private LocalDate orderDate;
    private LocalDate expectedDeliveryDate;
    private Long totalAmount;
    private String shippingAddress;
    private LocalDate shippingdate;
    private String paymentMethod;
    private boolean isPaid;
    private boolean isShipped;
    private boolean outForDelivery;
    private boolean isDelivered;
    private String categoryname;
    private Long productId;
    private Long addressId;
    private Long UserId;
    private String username;


}
