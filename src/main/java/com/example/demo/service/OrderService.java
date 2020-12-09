package com.example.demo.service;

import com.example.demo.entity.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    ResponseEntity<?> getOrderById(Long orderId);

    Orders updateOrder(Orders orders);

    Boolean cancelOrder(Long orderId);

    ResponseEntity<?> getOrdersByCustomerId(Long customerId);

    ResponseEntity<?> addBulkOrders(List<Orders> ordersList);
}
