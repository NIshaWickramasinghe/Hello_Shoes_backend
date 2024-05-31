package com.example.hello_shoes_02.entity;


import com.example.hello_shoes_02.entity.enumclasses.Gender;
import com.example.hello_shoes_02.entity.enumclasses.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    private String employeeId;
    private String emp_Name;
    private String profile_pic;

    @Temporal(TemporalType.DATE)
    private Date emp_DOB;
    private String civil_status;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String mobile;
    private String email;
    private String guardian;
    private String emergency_no;
    private String building_no;
    private String lane;
    private String city;
    private String state;
    private String postal_code;
    private String designation;

    @Temporal(TemporalType.DATE)
    private Date join_date;
    private String branch;

    @Enumerated(EnumType.STRING)
    private Role role;












}
