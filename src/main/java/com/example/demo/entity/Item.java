package com.example.demo.entity;


import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 *This is the entity class for Order Items details
 */
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    //@NonNull
    private String name;

    //@NonNull
    private Integer qty;

    //@NonNull
    private Double subtotal;

    //@NonNull
    private Double tax;

    //@NonNull
    @UpdateTimestamp
    private Date updatedTime;

    //@NonNull
    //private Boolean isCancel;

    /*@ManyToOne
    private Orders orderEntity;*/
}
