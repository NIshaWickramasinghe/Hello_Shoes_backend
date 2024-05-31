package com.example.hello_shoes_02.dto;


import com.example.hello_shoes_02.entity.enumclasses.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO {
    private String supplierCode;
    private String sup_name;
    private Category category;
    private String mobile;
    private String landLine;
    private String email;
    private String building_no;
    private String lane;
    private String city;
    private String state;
    private String postal_code;
    private String country;
}
