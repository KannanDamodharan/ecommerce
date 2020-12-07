package com.example.demo.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

/**
 *This is the entity class for Order Address details. This entity maintains both shipping and billing addresses
 */
@Data
@Entity(name = "Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    //@NonNull
    private String orderShippingAddressline1;

    private String orderShippingAddressline2;

    //@NonNull
    private String orderCity;

    //@NonNull
    private String orderState;

    //@NonNull
    private String orderZip;

    //@NonNull
    private String addressType;

    //@NonNull
    private Date updatedTime;
}
