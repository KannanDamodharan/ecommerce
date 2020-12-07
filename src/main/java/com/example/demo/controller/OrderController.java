package com.example.demo.controller;


import com.example.demo.dto.OrderDetailsDTO;
import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.PaymentEntity;
import com.example.demo.service.OrderService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *This controller receives all order related service calls.
 *Below methods perform Get, Put, Post, Delete are performed for a given order
 */
@RestController
@Slf4j
@Data
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *getOrder method accepts orderId and contacts service layer for fetching order details
     * @return OrderDetailsDTO
     */
    @GetMapping("/order/{orderId}")
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
    @PostMapping("/createOrder")
    public ResponseEntity<?> addOrder(@RequestBody OrderDetailsDTO orderDetailsDTO) throws Exception{
        log.debug("Create Order CustomerId: "+orderDetailsDTO.getOrderCustomerId());
        log.info("Create Order orderId"+orderDetailsDTO.getOrderId());
        return new ResponseEntity<>(orderService.createOrder(orderDetailsDTO), HttpStatus.CREATED);
    }

    /**
     *
     * @return
     */
    @GetMapping("/createData")
    public OrderDetailsDTO create() throws Exception{
        log.info("inside create data");
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        orderDetailsDTO.setOrderCustomerId(new Long(1234));
        orderDetailsDTO.setOrderStatus("Receivd");
        orderDetailsDTO.setOrderTotal(new Double(1294.55));
        orderDetailsDTO.setOrderShippingCharges(new Double(74.6));
        ItemEntity itemEntity1 = new ItemEntity();
        ItemEntity itemEntity2 = new ItemEntity();

        AddressEntity addressEntity1 = new AddressEntity();
        AddressEntity addressEntity2 = new AddressEntity();

        PaymentEntity paymentEntity1 = new PaymentEntity();
        PaymentEntity paymentEntity2 = new PaymentEntity();

        //itemEntity1.setItemId(new Long(57675));
        itemEntity1.setOrderItemName("Ipad");
        itemEntity1.setOrderItemQty(10);
        itemEntity1.setOrderSubtotal(new Double(3223.2));
        itemEntity1.setOrderTax(new Double(212.9));

        //itemEntity2.setItemId(new Long(782));
        itemEntity2.setOrderItemName("Ipad2");
        itemEntity2.setOrderItemQty(3);
        itemEntity2.setOrderSubtotal(new Double(333.2));
        itemEntity2.setOrderTax(new Double(26.9));

        //addressEntity1.setAddressId(new Long(1344));
        addressEntity1.setAddressType("shipping");
        addressEntity1.setOrderShippingAddressline1("4 Mozart Street");
        addressEntity1.setOrderShippingAddressline2("");
        addressEntity1.setOrderCity("Binghamton");
        addressEntity1.setOrderState("New York");
        addressEntity1.setOrderZip("13905");

        //addressEntity2.setAddressId(new Long(1449));
        addressEntity2.setAddressType("billing");
        addressEntity2.setOrderShippingAddressline1("4 Mozart Street");
        addressEntity2.setOrderShippingAddressline2("");
        addressEntity2.setOrderCity("Binghamton");
        addressEntity2.setOrderState("New York");
        addressEntity2.setOrderZip("13905");

        //paymentEntity1.setPaymentId(new Long(3132));
        paymentEntity1.setOrderPaymentConfirmationNumber(new Long(1231));

        //paymentEntity2.setPaymentId(new Long(324));
        paymentEntity2.setOrderPaymentConfirmationNumber(new Long(74665));

        List<PaymentEntity> paymentEntityList = new ArrayList<>();
        paymentEntityList.add(paymentEntity1);
        paymentEntityList.add(paymentEntity2);

        List<AddressEntity> addressEntityList = new ArrayList<>();
        addressEntityList.add(addressEntity1);
        addressEntityList.add(addressEntity2);

        List<ItemEntity> itemEntityList = new ArrayList<>();
        itemEntityList.add(itemEntity1);
        itemEntityList.add(itemEntity2);

        orderDetailsDTO.setPaymentEntityList(paymentEntityList);
        orderDetailsDTO.setAddressEntity(addressEntityList);
        orderDetailsDTO.setItemEntityList(itemEntityList);

        OrderEntity orderEntity = orderService.updateOrder(orderDetailsDTO);
        log.info("Before return -"+orderEntity.getOrderId());
        return orderDetailsDTO;
    }

    /**
     *getOrder method accepts OrderDetailsDTO and calls service layer for updating an existing order
     * @return OrderDetailsDTO (with newly generated ids if needed)
     */
    @PutMapping("/updateOrder")
    public ResponseEntity<?> updateOrder(@RequestBody OrderDetailsDTO orderDetailsDTO) throws Exception{
        return new ResponseEntity<>(orderService.updateOrder(orderDetailsDTO),HttpStatus.OK);
    }

    /**
     *getOrder method accepts OrderDetailsDTO and calls service layer for creating new order
     * @return OrderDetailsDTO with new orderId
     */
    @DeleteMapping("/cancelOrder/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId){
        if(orderService.cancelOrder(orderId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
