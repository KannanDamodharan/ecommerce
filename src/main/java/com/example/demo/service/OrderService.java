package com.example.demo.service;

import com.example.demo.dto.OrderDetailsDTO;
import com.example.demo.entity.OrderEntity;

import java.util.Optional;

public interface OrderService {
    Optional<OrderEntity> getOrderById(Long orderId);

    OrderDetailsDTO createOrder(OrderDetailsDTO orderDetailsDTO) throws Exception;

    OrderEntity updateOrder(OrderDetailsDTO orderDetailsDTO) throws Exception;

    Boolean cancelOrder(Long orderId);
}
