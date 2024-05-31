package com.example.hello_shoes_02.service.impl;


import com.example.hello_shoes_02.dao.CustomerRepo;
import com.example.hello_shoes_02.dto.CustomerDTO;
import com.example.hello_shoes_02.entity.CustomerEntity;
import com.example.hello_shoes_02.service.CustomerService;
import com.example.hello_shoes_02.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo repo;
    private final Mapping mapping;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
//        customerDTO.setCustomerId(UUID.randomUUID().toString());
        return mapping.toCustomerDTO(repo.save(mapping.toCustomer(customerDTO)));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.toCustomerDTOList(repo.findAll());
    }

    @Override
    public void deleteCustomer(String customerId) {
        repo.deleteById(customerId);
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        Optional<CustomerEntity> optionalCustomer = repo.findById(customerId);
        return optionalCustomer.map(mapping::toCustomerDTO).orElse(null);
    }

    @Override
    public CustomerEntity updateCustomer(String id, CustomerDTO updatedCustomer) {
        Optional<CustomerEntity> optionalCustomer = repo.findById(id);
        if(optionalCustomer.isPresent()){
            CustomerEntity existingCustomer = optionalCustomer.get();

            existingCustomer.setCustomerId(updatedCustomer.getCustomerId());
            existingCustomer.setCust_name(updatedCustomer.getCust_name());
            existingCustomer.setDob(updatedCustomer.getDob());
            existingCustomer.setGender(updatedCustomer.getGender());
            existingCustomer.setMobile(updatedCustomer.getMobile());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setBuilding_no(updatedCustomer.getBuilding_no());
            existingCustomer.setLane(updatedCustomer.getLane());
            existingCustomer.setCity(updatedCustomer.getCity());
            existingCustomer.setState(updatedCustomer.getState());
            existingCustomer.setPostalCode(updatedCustomer.getPostalCode());
            existingCustomer.setJoin_date(updatedCustomer.getJoin_date());
            existingCustomer.setRecent_purchase(updatedCustomer.getRecent_purchase());
            existingCustomer.setTotal_points(updatedCustomer.getTotal_points());
            existingCustomer.setLevel(updatedCustomer.getLevel());


            return repo.save(existingCustomer);

        }else {
            return null;
        }
    }
}
