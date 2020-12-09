package com.example.demo.controller;



import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *This controller receives all order related service calls.
 *Below methods perform Get, Put, Post, Delete are performed for a given order
 */
@RestController
@Slf4j
@Data
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *getOrder method accepts orderId and fetches the order details for the id
     * @return ResponseEntity with the updated HTTPStatus
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId){
        log.debug("Get Order orderId: "+orderId);
        if(orderId!=null) {
            return orderService.getOrderById(orderId);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Orders orders){
        if(orders!=null) {
            return new ResponseEntity<>(orderService.updateOrder(orders), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody Orders orders) throws Exception{
        if(orders!=null) {
            return new ResponseEntity<>(orderService.updateOrder(orders), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     *cancelOrder method accepts orderId and cancels the order for the given orderId.
     * @return ResponseEntity with updated httpstatus
     */
    @DeleteMapping
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId){
        log.debug("cancel Order orderId: "+orderId);
        if(orderId!=null){
            return new ResponseEntity<>(orderService.cancelOrder(orderId),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     *getOrders method accepts customerId and returns with all the orders of the customer
     * @return ResponseEntity with updated httpstatus
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getOrders(@PathVariable Long customerId){
        log.debug("getOrders customerId: "+customerId);
        if(customerId!=null) {
            return new ResponseEntity<>(orderService.getOrdersByCustomerId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     *getOrders method accepts customerId and returns with all the orders of the customer
     * @return ResponseEntity with updated httpstatus
     */
    @PostMapping("/bulk")
    public ResponseEntity<?> addOrders(@RequestBody List<Orders> orderList){
        if(orderList!=null && orderList.size()>0) {
            return orderService.addBulkOrders(orderList);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
