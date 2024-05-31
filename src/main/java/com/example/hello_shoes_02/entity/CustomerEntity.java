package com.example.hello_shoes_02.entity;


import com.example.hello_shoes_02.entity.enumclasses.Gender;
import com.example.hello_shoes_02.entity.enumclasses.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity{

    @Id
    private String customerId;
    private String cust_name;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String mobile;
    private String email;
    private String building_no;
    private String lane;
    private String city;
    private String state;
    private String postalCode;

    @Temporal(TemporalType.DATE)
    private Date join_date;
    private Timestamp recent_purchase;
    private Integer total_points;

    @Enumerated(EnumType.STRING)
    private Level level;








}
