package com.example.hello_shoes_02.entity;


import com.example.hello_shoes_02.entity.enumclasses.Category;
import com.example.hello_shoes_02.entity.enumclasses.StockStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="item")
public class ProductEntity {
    @Id
    private String item_code;
    private String item_desc;
    private String item_picture;
    private Category category;
    private Integer size;
    private Double sale_price;
    private Double expected_profit;
    private Double profit_margin;

    @Enumerated(EnumType.STRING)
    private StockStatus status;

}
