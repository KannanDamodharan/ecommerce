package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String orderShippingAddressline1;
    private String orderShippingAddressline2;
    private String orderCity;
    private String orderState;
    private String orderZip;
    //To avoid multiple columns
    private String addressType;
    private Date updatedTime;
}
