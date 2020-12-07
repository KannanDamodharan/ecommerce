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
 *This is the entity class for Order Items details
 */
@Data
@Entity(name = "Item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    //@NonNull
    private String orderItemName;

    //@NonNull
    private Integer orderItemQty;

    //@NonNull
    private Double orderSubtotal;

    //@NonNull
    private Double orderTax;

    //@NonNull
    private Date updatedTime;

    //@NonNull
    private Boolean isCancel;
}
