package com.ecommerce.amazon.service.ServiceImplemenation;

import com.ecommerce.amazon.dto.OrderDto;
import com.ecommerce.amazon.model.*;
import com.ecommerce.amazon.repository.*;
import com.ecommerce.amazon.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService   {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, AddressRepository addressRepository , UserRepository userRepository, CartItemRepository cartItemRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;

    }

    public List<Order> getDeliveredOrdersByUser(User user) {
        List<Order> orderDet = orderRepository.findByUserAndIsDeliveredTrue(user);

        return orderRepository.findByUserAndIsDeliveredTrue(user);
    }

    @Override
    public void createOrder(OrderDto orderDTO) {
        Product product = productRepository.getById(orderDTO.getProductId());
        Address address = addressRepository.getById(orderDTO.getAddressId());
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setExpectedDeliveryDate(LocalDate.now().plusDays(7));
        order.setTotalAmount(product.getPrice());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setProduct(product);
    Long id= product.getId();
        User user = userRepository.findById(orderDTO.getUserId()).get();

        order.setUser(user);
        Cart_Item cartItem=cartItemRepository.findByUserAndproductId(user,product);
        System.out.println(cartItem);
        cartItemRepository.deleteById(cartItem.getId());

      order.setHouseno(address.getHouseno());
      order.setArea(address.getArea());
      Address ad=addressRepository.findById(address.getId()).get();
      order.setAddress(ad);
        order.setPaid(false);
        order.setShipped(false);
        order.setDelivered(false);
        String username = user.getName();
        order.setUsername(username);

        orderRepository.save(order);
    }
   public List<Product> recommendedProducts(Long id){
        List<Product> products = mapToProductList(orderRepository.findRecommendedOrdersByUserId(id));
       return products;
   }

    private List<Product> mapToProductList(List<Order> orders) {
        return orders.stream()
                .map(x->x.getProduct())
                .collect(Collectors.toList());
    }

}

