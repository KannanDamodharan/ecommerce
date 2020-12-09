package com.example.demo.entity;


import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
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

    @NonNull
    private String name;

    @NonNull
    @Min(1)
    private Integer qty;

    @NonNull
    @DecimalMin("0.00")
    private Double subtotal;

    @NonNull
    @DecimalMin("0.00")
    private Double tax;

    @NonNull
    @UpdateTimestamp
    private Date updatedTime;
}
