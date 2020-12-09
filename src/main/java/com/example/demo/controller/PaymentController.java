package com.example.demo.controller;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*PaymentController saves all payment confirmation details
 * PUT and POST are performed*/

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping
    public ResponseEntity<?> addPaymentDetails(@RequestBody Payment payment) throws Exception{
        return new ResponseEntity<>(paymentService.updatePayment(payment), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updatePaymentDetails(@RequestBody Payment payment) throws Exception{
        return new ResponseEntity<>(paymentService.updatePayment(payment), HttpStatus.OK);
    }
}
