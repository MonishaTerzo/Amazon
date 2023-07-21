package com.ecommerce.amazon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
    private LocalDate shippingDate;
    private String paymentMethod;
    private boolean isPaid;
    private boolean isShipped;
    private boolean outForDelivery;
    private boolean isDelivered;
    private String username;
    private String houseNo;
    private String area;
    private int review;
    private String reviewDescription;
    private LocalDate reviewDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
