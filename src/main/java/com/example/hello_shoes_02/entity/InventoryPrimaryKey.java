package com.example.hello_shoes_02.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class InventoryPrimaryKey implements SuperEntity {
    private String itemCode;
    private String supplierCode;
}
