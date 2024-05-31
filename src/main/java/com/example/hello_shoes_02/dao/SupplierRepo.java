package com.example.hello_shoes_02.dao;

import com.example.hello_shoes_02.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity,String> {

    Optional<SupplierEntity>findById(String supplierId);
}
