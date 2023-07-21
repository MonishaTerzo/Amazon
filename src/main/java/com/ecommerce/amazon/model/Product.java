package com.ecommerce.amazon.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @Entity
    @Table(name = "products")
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private double count;
        private String name;
        private String description;
        private Long price;
        
        private String imageUrl;


        @ManyToOne
        @JoinColumn(name = "rating_id")
        private Rating rating;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    }
