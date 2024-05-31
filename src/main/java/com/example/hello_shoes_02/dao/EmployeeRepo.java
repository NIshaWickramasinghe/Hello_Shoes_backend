package com.example.hello_shoes_02.dao;

import com.example.hello_shoes_02.entity.CustomerEntity;
import com.example.hello_shoes_02.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
    Optional<EmployeeEntity> findById(String employeeId);
}
