package com.example.hello_shoes_02.controller;


import com.example.hello_shoes_02.dto.CustomerDTO;
import com.example.hello_shoes_02.entity.CustomerEntity;
import com.example.hello_shoes_02.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin
public class Customer {
    private final CustomerService customerService;

    @GetMapping("/health")
    public String healthCheck(){
        return "customer HealthCheck success";
    }

    @PostMapping("/addcustomer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/getallcustomer")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/deletecustomer/{customerId}")
    public ResponseEntity<String>deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    @GetMapping("/selectcustomer/{customerId}")
    public ResponseEntity<CustomerDTO>getSelectedCustomer(@PathVariable String customerId){
        CustomerDTO customer = customerService.getSelectedCustomer(customerId);
        if(customer != null){
            return ResponseEntity.ok(customer);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable String customerId,
                                                         @RequestBody CustomerDTO updatedCustomer){
        CustomerEntity customer = customerService.updateCustomer(customerId,updatedCustomer);
        if(customer != null){
            return ResponseEntity.ok(customer);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
