package com.ecommerce.amazon.controller;

import com.ecommerce.amazon.dto.OrderDto;
import com.ecommerce.amazon.model.Order;
import com.ecommerce.amazon.model.Product;
import com.ecommerce.amazon.model.User;
import com.ecommerce.amazon.service.OrderService;
import com.ecommerce.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api")
public class OrderController {
        private final OrderService orderService;
        private final UserService userService;

        @Autowired
        public OrderController(OrderService orderService,UserService userService) {
            this.orderService = orderService;
            this.userService=userService;
        }
        @GetMapping("/{userId}/delivered")
        public List<OrderDto> getDeliveredOrdersByUser(@PathVariable int userId) {
            User user = userService.getUserById(userId);
            return mapToDtoList(orderService.getDeliveredOrdersByUser(user));

        }
    private List<OrderDto> mapToDtoList(List<Order> orders) {
            return orders.stream()
                    .map(x->mapToDto(x))
                    .collect(Collectors.toList());
    }
    private OrderDto mapToDto(Order order) {
            return OrderDto.builder()
                    .orderDate(order.getOrderDate())
                    .expectedDeliveryDate(order.getExpectedDeliveryDate())
                    .isPaid(order.isPaid())
                    .isShipped(order.isShipped())
                    .outForDelivery(order.isOutForDelivery())
                    .shippingAddress(order.getShippingAddress())
                    .shippingdate(order.getShippingdate())
                    .paymentMethod(order.getPaymentMethod())
                    .totalAmount(order.getTotalAmount())
                    .username(order.getUsername())
                    .build();
    }
    @PostMapping("/placeOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDTO) {
        orderService.createOrder(orderDTO);
        return new ResponseEntity<>("Order created successfully.", HttpStatus.CREATED);

    }
}