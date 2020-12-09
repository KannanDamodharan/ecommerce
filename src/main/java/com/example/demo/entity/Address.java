package com.example.demo.entity;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 *This is the entity class for Order Address details. This entity maintains both shipping and billing addresses
 */
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @NonNull
    private String addressline1;

    private String addressline2;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String zip;

    @NonNull
    private String addressType;

    @NonNull
    @UpdateTimestamp
    private Date updatedTime;

}
