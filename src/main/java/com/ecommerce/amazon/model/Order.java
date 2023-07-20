package com.ecommerce.amazon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name="orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String username;
    private String houseno;
    private String area;
    private int review;
    private String reviewDescription;
    private LocalDate reviewDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}