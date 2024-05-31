package com.example.hello_shoes_02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {
    private String orderId;
    private String cust_name;
    private String cashier;
    private String itemCode;
    private String item_desc;
    private Integer size;
    private Double unit_price;
    private Integer qty;
    private Timestamp purchase_date;
    private Double total_price;
    private Integer added_points;
    private String pay_method;

}
