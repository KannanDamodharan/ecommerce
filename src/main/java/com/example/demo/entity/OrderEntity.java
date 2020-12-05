package com.example.demo.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Entity(name = "orderItem")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    private String order_status;
    private String order_customer_id;
    private Integer order_shipping_charges;
    private Integer order_total;
    private Boolean isCancel;
}
