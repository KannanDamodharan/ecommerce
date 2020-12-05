package com.example.demo;


import com.example.demo.dao.OrderDao;
import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderServiceImpl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Data
@Getter
@Setter
class DemoApplicationTests {


    /*@Autowired
    OrderServiceImpl orderService;

    @Autowired
    private JpaRepository<OrderEntity, Integer> repo;

    @Test
    public void testGetOrderId(){
        System.out.println("heloooooooooooooooo");
        OrderServiceImpl orderService = new OrderServiceImpl();
        OrderEntity orderEntity = new OrderEntity();


    }*/
}
