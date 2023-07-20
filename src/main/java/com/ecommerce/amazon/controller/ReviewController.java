package com.ecommerce.amazon.controller;

import com.ecommerce.amazon.dto.ReviewDto;
import com.ecommerce.amazon.service.ReviewService;
import com.ecommerce.amazon.service.ServiceImplemenation.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PutMapping("/{orderId}")
    private String  ReviewProduct(@PathVariable Long orderId, @RequestBody ReviewDto reviewDto){
        reviewDto.setId(orderId);
        System.out.println(reviewDto);
        reviewService.AddReview(reviewDto);
        return "thanks for your review keep shopping";

    }
}
