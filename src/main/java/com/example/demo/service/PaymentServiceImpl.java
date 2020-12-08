package com.example.demo.service;

import com.example.demo.dao.PaymentDao;
import com.example.demo.entity.Payment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class PaymentServiceImpl {

    @Autowired
    private PaymentDao paymentDao;

    public Payment updatePayment(Payment payment) {
        return paymentDao.save(payment);
    }
}
