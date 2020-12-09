package com.example.demo.kafka;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    
    @Autowired
    private OrderService orderService;

    private ObjectMapper mapper;



    /*receive method accepts ConsumerRecord<?, ?> and converts to json string
    * and then json mapped to Order Model class to save the order.
    */
    @KafkaListener(topics = "${test.topic}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        Orders order = null;
        mapper = new ObjectMapper();
        String value = String.valueOf(consumerRecord.value());
        try {
            order = mapper.readValue(value, Orders.class);
        }
        catch (JsonProcessingException exception){
            log.error("Exception kafkaConsumer: ", exception);
        }
        if(order!=null) {
            orderService.updateOrder(order);
        }
    }

}
