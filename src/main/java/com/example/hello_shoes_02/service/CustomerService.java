package com.example.hello_shoes_02.service;


import com.example.hello_shoes_02.dto.CustomerDTO;
import com.example.hello_shoes_02.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    void deleteCustomer(String customerId);
    CustomerDTO getSelectedCustomer(String customerId);
    CustomerEntity updateCustomer(String id, CustomerDTO updatedCustomer);


}
