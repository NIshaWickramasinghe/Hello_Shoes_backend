package com.example.hello_shoes_02.dao;

import com.example.hello_shoes_02.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepo extends JpaRepository<SaleEntity,String> {
    Optional<SaleEntity> findById(String saleId);
}
