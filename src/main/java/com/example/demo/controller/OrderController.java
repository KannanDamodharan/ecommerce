package com.example.demo.controller;


import com.example.demo.dto.OrderDetailsDTO;
import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.PaymentEntity;
import com.example.demo.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/order/{orderId}")
    public Optional<OrderEntity> getOrder(@PathVariable Long orderId){
        log.debug("Get Order orderId: "+orderId);
        if(orderId!=null) {
            return orderService.getOrderById(orderId);
        }
        return Optional.empty();
    }

    @PostMapping("/createOrder")
    public void addOrder(@RequestBody OrderDetailsDTO orderDetailsDTO){
        log.info("insidereateOrder");
        orderService.createOrder(orderDetailsDTO);
    }

    /**
     *
     * @return
     */
    @GetMapping("/createData")
    public OrderDetailsDTO create(){
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

        orderService.createOrder(orderDetailsDTO);
        return orderDetailsDTO;
    }

    //implement update order
    @PutMapping("/updateOrder")
    public void updateOrder(@RequestBody OrderDetailsDTO orderDetailsDTO){
        orderService.createOrder(orderDetailsDTO);
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public Boolean cancelOrder(@PathVariable Long orderId){
        return orderService.cancelOrder(orderId);
    }

}
