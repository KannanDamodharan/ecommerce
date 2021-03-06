package com.example.demo.entity;


import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 *This is the entity class for Payment details
 */
@Data
@Entity
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    @NonNull
    private String paymentMethod;

    @UpdateTimestamp
    private Date paymentDate;

    @NonNull
    private Long confirmationNumber;

}
