package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Orders;
import com.example.demo.kafka.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private KafkaProducer kafkaProducer;

    private ObjectMapper mapper;

    @Value("${test.topic}")
    private String topic;

    public ResponseEntity<?> getOrderById(Long orderId){
        Optional<Orders> order = Optional.empty();;
        try {
            order = orderDao.findById(orderId);
        } catch (DataAccessException exception) {
            log.error("DataAccessException at getOrderById : ",exception);
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if(order.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    public Orders updateOrder(Orders order){
        try {
            order = orderDao.save(order);
        }
        catch (DataAccessException e){
            log.error("DataAccessException at updateOrder",e);
        }
        catch (Exception e){
            log.error("Exception at updateOrder",e);
        }
        return order;
    }

    public Boolean cancelOrder(Long orderId) {
        try{
            orderDao.updateOrder(orderId);
        }
        catch (DataAccessException e){
            log.error("DataAccessException at cancelOrder service: ",e);
            return false;
        }
        catch (Exception e){
            log.error("Exception at cancelOrder service: ",e);
            return false;
        }
        return true;
    }

    public ResponseEntity<?> getOrdersByCustomerId(Long customerId){
        List<Orders> orders;
        try{
            orders = orderDao.findByCustomerId(customerId);
        }
        catch (DataAccessException e){
            log.error("DataAccessException at cancelOrder service: ",e);
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        catch (Exception e){
            log.error("Exception at cancelOrder service: ",e);
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if(orders!=null && orders.size()>0){
            return new ResponseEntity<>(orders,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> addBulkOrders(List<Orders> ordersList){
        if(ordersList!=null) {
            mapper = new ObjectMapper();
            for(Orders order:ordersList){
                try {
                    kafkaProducer.send(topic, mapper.writeValueAsString(order));
                }
                catch (JsonProcessingException exception){
                    log.error("JsonProcessingException at addBulkOrders - ",exception);
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                catch (Exception exception){
                    log.error("Exception at addBulkOrders- ",exception);
                    return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
                }
            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
