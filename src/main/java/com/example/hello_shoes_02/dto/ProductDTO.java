package com.example.hello_shoes_02.dto;


import com.example.hello_shoes_02.entity.enumclasses.Category;
import com.example.hello_shoes_02.entity.enumclasses.StockStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private String item_code;
    private String item_desc;
    private String item_picture;
    private Category category;
    private Integer size;
    private Double  sale_price;
//    private Double buy_price;
    private Double expected_profit;
    private Double profit_margin;
    private StockStatus status;


}
