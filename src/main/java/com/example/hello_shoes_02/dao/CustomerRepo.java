package com.example.hello_shoes_02.dao;


import com.example.hello_shoes_02.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
    Optional<CustomerEntity> findById(String customerId);
}
