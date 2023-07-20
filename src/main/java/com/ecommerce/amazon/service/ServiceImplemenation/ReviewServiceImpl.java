package com.ecommerce.amazon.service.ServiceImplemenation;

import com.ecommerce.amazon.dto.OrderDto;
import com.ecommerce.amazon.dto.ReviewDto;
import com.ecommerce.amazon.model.Order;
import com.ecommerce.amazon.repository.OrderRepository;
import com.ecommerce.amazon.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReviewServiceImpl implements ReviewService{
    public ReviewServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private final OrderRepository orderRepository;

@Override
    public void AddReview(ReviewDto reviewDto){
       Order order=orderRepository.getById(reviewDto.getId());
       if(order.isDelivered()){
           order.setReview(reviewDto.getReview());
           order.setReviewDescription(reviewDto.getReviewDescription());
           order.setReviewDate(LocalDate.now());    }
       orderRepository.save(order);

    }
}
