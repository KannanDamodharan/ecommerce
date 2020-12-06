package com.example.demo.entity;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity(name = "orderItem")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    //@NonNull
    private String orderStatus;

    //@NonNull
    private Long orderCustomerId;

    //@NonNull
    private Double orderShippingCharges;

    //@NonNull
    private String shippingDelivery;

    //@NonNull
    private Double orderTotal;

    //@NonNull
    private Boolean isCancel;

    //@NonNull
    private Date createdTime;

    //@NonNull
    private Date updatedTime;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<ItemEntity> itemEntity;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<PaymentEntity> paymentEntity;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<AddressEntity> addressEntity;


}
