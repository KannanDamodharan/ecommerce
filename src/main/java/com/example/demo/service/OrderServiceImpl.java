package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderDetailsDTO;
import com.example.demo.entity.OrderEntity;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@Setter
@Slf4j
public class OrderServiceImpl {

    @Autowired
    private OrderDao orderDao;

    public Optional<OrderEntity> getOrderById(Long orderId){
        Optional<OrderEntity> obj = orderDao.findById(orderId);
        return obj;
    }

    public void createOrder(OrderDetailsDTO orderDetailsDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderCustomerId(orderDetailsDTO.getOrderCustomerId());
        orderEntity.setOrderStatus(orderDetailsDTO.getOrderStatus());
        orderEntity.setOrderShippingCharges(orderDetailsDTO.getOrderShippingCharges());
        orderEntity.setOrderTotal(orderDetailsDTO.getOrderTotal());

        orderEntity.setOrderShippingCharges(orderDetailsDTO.getOrderShippingCharges());

        orderEntity.setPaymentEntity(orderDetailsDTO.getPaymentEntityList());
        orderEntity.setItemEntity(orderDetailsDTO.getItemEntityList());
        orderEntity.setAddressEntity(orderDetailsDTO.getAddressEntity());

        log.info("save method");
        orderDao.save(orderEntity);
        log.info("after save");
    }

    public void cancelOrder(int orderId) {
        orderDao.updateOrder(orderId);
        /*Optional<OrderEntity> obj = orderDao.findById(orderId);
        log.info("delete called in servic");
        if(obj.isPresent()) {
            obj.get().setIsCancel(Boolean.TRUE);
            orderDao.save(obj.get());
        }*/
    }
}
