package com.example.demo.dto;

import lombok.Data;

@Data
public class OrderDetailsDTO {

    private String orderStatus;
    private String orderCustomerId;
    private Integer orderShippingCharges;
    private Integer orderTotal;


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
