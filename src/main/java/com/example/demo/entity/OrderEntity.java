package com.example.demo.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity(name = "orderItem")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String orderStatus;
    private Long orderCustomerId;
    private Double orderShippingCharges;
    private Double orderTotal;
    private Boolean isCancel;

    private Date createdTime;
    private Date updatedTime;

    private String createdBy;
    private String updatedBy;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<ItemEntity> itemEntity;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<PaymentEntity> paymentEntity;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<AddressEntity> addressEntity;


}
