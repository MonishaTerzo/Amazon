package com.ecommerce.amazon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String city;
     private String state;
     private String pincode;
     private String houseno;
     private String Area;
     private String landmark;
     private String addresstype;
     @ManyToOne
     @JoinColumn(name = "user_id")
     private User user;
}
