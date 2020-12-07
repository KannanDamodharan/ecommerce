package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderDetailsDTO;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.OrderEntity;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@Setter
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    public Optional<OrderEntity> getOrderById(Long orderId){
        if(orderId!=null) {
            return orderDao.findById(orderId);
        }
        return Optional.empty();
    }

    public OrderDetailsDTO createOrder(OrderDetailsDTO orderDetailsDTO) throws Exception{
        OrderEntity orderEntity  = updateOrder(orderDetailsDTO);
        if(null!=orderEntity){
            orderDetailsDTO.setOrderId(orderEntity.getOrderId());

            orderDetailsDTO.setAddressEntity(orderEntity.getAddressEntity());
            orderDetailsDTO.setItemEntityList(orderEntity.getItemEntity());
            orderDetailsDTO.setPaymentEntityList(orderEntity.getPaymentEntity());
            return orderDetailsDTO;
        }
        return null;
    }

    public OrderEntity updateOrder(OrderDetailsDTO orderDetailsDTO) throws Exception{

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderId(orderDetailsDTO.getOrderId());
        orderEntity.setOrderCustomerId(orderDetailsDTO.getOrderCustomerId());
        orderEntity.setOrderStatus(orderDetailsDTO.getOrderStatus());

        orderEntity.setOrderShippingCharges(orderDetailsDTO.getOrderShippingCharges());
        orderEntity.setOrderTotal(orderDetailsDTO.getOrderTotal());

        orderEntity.setOrderShippingCharges(orderDetailsDTO.getOrderShippingCharges());

        orderEntity.setPaymentEntity(orderDetailsDTO.getPaymentEntityList());
        orderEntity.setItemEntity(orderDetailsDTO.getItemEntityList());
        orderEntity.setAddressEntity(orderDetailsDTO.getAddressEntity());

        log.info("save method");
        try {
            return orderDao.save(orderEntity);
        }
        catch (DataException dataException){
            log.error("Data Exception"+dataException.getMessage());
        }
        return null;
    }

    public Boolean cancelOrder(Long orderId) {
        if(orderId!=null) {
            orderDao.updateOrder(orderId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
