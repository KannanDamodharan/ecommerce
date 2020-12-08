package com.example.demo.service;

import com.example.demo.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Orders> getOrderById(Long orderId);

    Orders updateOrder(Orders orders) throws Exception;

    Boolean cancelOrder(Long orderId);

    List<Orders> getOrdersByCustomerId(Long customerId);
}
