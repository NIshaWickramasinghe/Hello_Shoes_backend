package com.example.hello_shoes_02.dto;


import com.example.hello_shoes_02.entity.enumclasses.Gender;
import com.example.hello_shoes_02.entity.enumclasses.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class CustomerDTO {
    private String customerId;
    private String cust_name;
    private Date dob;
    private Gender gender;
    private String mobile;
    private String email;
    private String building_no;
    private String lane;
    private String city;
    private String state;
    private String postalCode;
    private Date join_date;
    private Timestamp recent_purchase;
    private Integer total_points;
    private Level level;



}
