package com.example.demo.dao;

import com.example.demo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Long> {

    @Transactional
    @Modifying
    @Query(value="UPDATE orderItem SET isCancel = True WHERE order_id=?1")
    void updateOrder(Long orderId);

}
