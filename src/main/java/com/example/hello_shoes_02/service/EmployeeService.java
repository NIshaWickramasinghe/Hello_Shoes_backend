package com.example.hello_shoes_02.service;

import com.example.hello_shoes_02.dto.EmployeeDTO;
import com.example.hello_shoes_02.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO>getAllEmployee();
    void deleteEmployee(String employeeId);
    EmployeeDTO getSelectedEmployee(String employeeId);
    EmployeeEntity updateEmployee(String id, EmployeeDTO updatedEmployee);
}
