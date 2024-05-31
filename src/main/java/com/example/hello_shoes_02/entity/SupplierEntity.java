package com.example.hello_shoes_02.entity;


import com.example.hello_shoes_02.entity.enumclasses.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    private String supplierCode;
    private String sup_name;

    @Enumerated(EnumType.STRING)
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
