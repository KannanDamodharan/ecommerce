package com.example.demo.controller;


import com.example.demo.dto.OrderDetailsDTO;
import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/order/{orderId}")
    public Optional<OrderEntity> getOrder(@PathVariable int orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/createOrder")
    public void addOrder(@RequestBody OrderDetailsDTO orderDetailsDTO){
        log.info("insidereateOrder");
        orderService.createOrder(orderDetailsDTO);
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public void cancelOrder(@PathVariable int orderId){
        orderService.cancelOrder(orderId);
    }

}
