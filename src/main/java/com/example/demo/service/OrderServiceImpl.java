package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Orders;
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
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    public Optional<Orders> getOrderById(Long orderId){
        if(orderId!=null) {
            return orderDao.findById(orderId);
        }
        return Optional.empty();
    }

    public Orders updateOrder(Orders orders) throws Exception{
        return orderDao.save(orders);
    }

    public Boolean cancelOrder(Long orderId) {
        if(orderId!=null) {
            orderDao.updateOrder(orderId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<Orders> getOrdersByCustomerId(Long customerId){
        return orderDao.findByCustomerId(customerId);
    }
}
