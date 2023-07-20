package com.ecommerce.amazon.service;

import com.ecommerce.amazon.dto.OrderDto;
import com.ecommerce.amazon.dto.ReviewDto;

public interface ReviewService {
    void AddReview(ReviewDto reviewDto);
}
