package com.example.demo.controller;



import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     *getOrder method accepts orderId and contacts service layer for fetching order details
     * @return OrderDetailsDTO
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId){
        log.debug("Get Order orderId: "+orderId);
        if(orderId!=null) {
            return new ResponseEntity<>(orderService.getOrderById(orderId),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    /**
     *getOrder method accepts OrderDetailsDTO and calls service layer for creating new order
     * @return OrderDetailsDTO with new orderId
     */
    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Orders orders) throws Exception{
        return new ResponseEntity<>(orderService.updateOrder(orders), HttpStatus.CREATED);
    }

    /**
     *getOrder method accepts OrderDetailsDTO and calls service layer for updating an existing order
     * @return OrderDetailsDTO (with newly generated ids if needed)
     */
    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody Orders orders) throws Exception{
        return new ResponseEntity<>(orderService.updateOrder(orders),HttpStatus.OK);
    }

    /**
     *getOrder method accepts OrderDetailsDTO and calls service layer for creating new order
     * @return OrderDetailsDTO with new orderId
     */
    @DeleteMapping
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId){
        if(orderService.cancelOrder(orderId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getOrders(@PathVariable Long customerId){
        return new ResponseEntity<>(orderService.getOrdersByCustomerId(customerId),HttpStatus.OK);
    }

}
