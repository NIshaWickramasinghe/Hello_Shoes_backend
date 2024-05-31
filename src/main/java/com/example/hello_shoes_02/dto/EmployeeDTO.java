package com.example.hello_shoes_02.dto;


import com.example.hello_shoes_02.entity.enumclasses.Gender;
import com.example.hello_shoes_02.entity.enumclasses.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String employeeId;
    private String emp_Name;
    private String profile_pic;
    private Date emp_dob;
    private String civil_status;
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
    private Date join_date;
    private String branch;
    private Role role;
}
