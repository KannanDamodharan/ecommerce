package com.example.demo.dto;

import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.PaymentEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsDTO {

    private String orderStatus;
    private Long orderCustomerId;
    private Double orderShippingCharges;
    private Double orderTotal;

    private List<ItemEntity> itemEntityList;
    private List<AddressEntity> addressEntity;
    private List<PaymentEntity> paymentEntityList;


    /*private String orderItemName;
    private String orderItemQty;
    private String orderSubtotal;
    private String orderTax;

    private String order_subtotal;
    private String order_tax;
    private String order_shipping_charges;
    private String order_total;
    private String order_payment_method;
    private String order_payment_date;
    private String order_payment_confirmation_number;
    private String order_billing_addressline1;
    private String order_billing_addressline2;
    private String order_billing_city;
    private String order_billing_state;
    private String order_billing_zip;
    private String order_shipping_addressline1;
    private String order_shipping_addressline2;
    private String order_shipping_city;
    private String order_shipping_state;
    private String order_shipping_zip;*/
}
