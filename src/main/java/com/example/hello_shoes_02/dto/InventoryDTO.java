package com.example.hello_shoes_02.dto;


import com.example.hello_shoes_02.entity.enumclasses.StockStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDTO {
    private String stockId;
    private String itemCode;
    private String item_desc;
    private String shoe_type;
    private Integer size;
    private String supplierCode;
    private String sup_name;
    private Date lastDate;
    private Date nextDate;
    private Integer max_qty;
    private Integer qty;
    private StockStatus status;
    private Double buy_price;

}
