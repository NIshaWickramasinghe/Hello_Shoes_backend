package com.example.hello_shoes_02.controller;

import com.example.hello_shoes_02.dto.EmployeeDTO;
import com.example.hello_shoes_02.entity.EmployeeEntity;
import com.example.hello_shoes_02.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin
public class Employee {
    private final EmployeeService employeeService;

    @GetMapping("/health")
    public String healthCheck(){
        return "employee HealthCheck success";
    }

    @PostMapping("/addemployee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getallemployee")
    public List<EmployeeDTO>getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/deleteemployee/{employeeId}")
    public ResponseEntity<String>deleteEmployee (@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/selectemployee/{employeeId}")
    public ResponseEntity<EmployeeDTO> getSelectedEmployee (@PathVariable String employeeId){
        EmployeeDTO employee = employeeService.getSelectedEmployee(employeeId);
        if (employee != null){
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable String employeeId,
                                                         @RequestBody EmployeeDTO updatedEmployee){
        EmployeeEntity employee = employeeService.updateEmployee(employeeId,updatedEmployee);
        if(employee != null){
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
