package com.example.demo.dto;

import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.PaymentEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *This Data transfer Object is used to communicate with the Clients
 */
@Data
public class OrderDetailsDTO implements Serializable {

    private Long orderId;
    private String orderStatus;
    private Long orderCustomerId;
    private Double orderShippingCharges;
    private Double orderTotal;

    private List<ItemEntity> itemEntityList;
    private List<AddressEntity> addressEntity;
    private List<PaymentEntity> paymentEntityList;

}
