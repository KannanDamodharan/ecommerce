package com.example.demo.dao;

import com.example.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Orders, Long> {
    @Transactional
    @Modifying
    @Query(value="UPDATE orders SET isCancel = True WHERE order_id=?1")
    void updateOrder(Long orderId);

    List<Orders> findByCustomerId(Long customerId);
}
