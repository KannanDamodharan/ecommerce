package com.example.demo;

import com.example.demo.entity.Orders;
import com.example.demo.kafka.KafkaConsumer;
import com.example.demo.kafka.KafkaProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

@Slf4j
@RunWith(SpringRunner.class )
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class EmbeddedKafkaIntegrationTest {
    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducer producer;

    @Value("${test.topic}")
    private String topic;

    @Test
    public void testKafka() throws Exception {
        String str = "{\"orderStatus\":\"Received\",\"customerId\":125,\"shippingCharges\":5243.32,\"shippingDelivery\":\"263.77\",\"total\":67545,\"deliveryType\":\"SHIP_HOME\"}";
        producer.send(topic, str);
        //consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
        //assertThat(consumer.getLatch().getCount(), equalTo(0L));
        //assertThat(consumer.getPayload(), containsString("embedded-test-topic"));
    }

    @Test
    public void testJsonMapping() throws Exception{
        String str = "{\"orderStatus\":\"Received\",\"customerId\":125,\"shippingCharges\":5243.32,\"shippingDelivery\":\"263.77\",\"total\":67545,\"deliveryType\":\"SHIP_HOME\"}";
        ObjectMapper mapper = new ObjectMapper();
        Orders order = mapper.readValue(str, Orders.class);
        log.info("order status: "+order.getOrderStatus());
    }
}
