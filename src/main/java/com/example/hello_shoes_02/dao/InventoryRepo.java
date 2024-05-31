package com.example.hello_shoes_02.dao;

import com.example.hello_shoes_02.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepo extends JpaRepository<InventoryEntity,String> {
    @Override
    Optional<InventoryEntity> findById(String inventoryId);
}
