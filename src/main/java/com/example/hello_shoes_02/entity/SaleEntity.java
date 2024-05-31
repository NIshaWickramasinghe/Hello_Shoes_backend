package com.example.hello_shoes_02.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="sale")
public class SaleEntity {
    @Id
    private String orderId;
    private Timestamp purchase_date;
    private Double total_price;
    private Integer added_points;
    private String pay_method;

}
