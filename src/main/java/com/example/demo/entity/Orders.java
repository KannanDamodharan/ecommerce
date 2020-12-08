package com.example.demo.entity;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *This is the entity class for Order details
 */
enum DeliveryType {
    INSTORE_PICKUP, CURBSIDE_DELIVERY, SHIP_HOME, THIRD_PARTY_DELIVERY;
}

@Data
@Entity(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    //@NonNull
    private String orderStatus;

    //@NonNull
    private Long customerId;

    //@NonNull
    private Double shippingCharges;

    //@NonNull
    private String shippingDelivery;

    //@NonNull
    private Double total;

    //@NonNull
    @CreatedDate
    private Date createdTime;

    //@NonNull
    @UpdateTimestamp
    private Date updatedTime;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @OneToMany
    private List<Item> items;

    @OneToMany
    private List<Payment> payment;

    @OneToMany
    private List<Address> address;

}
