package com.example.demo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 *This is the entity class for Payment details
 */
@Data
@Entity(name = "Payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    //@NonNull
    private String orderPaymentMethod;

    //@NonNull
    private Date orderPaymentDate;

    //@NonNull
    private Long orderPaymentConfirmationNumber;

    /*//@NonNull
    private Date updatedTime;*/
}
