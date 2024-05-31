package com.example.hello_shoes_02.dao;

import com.example.hello_shoes_02.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,String> {
    @Override
    Optional<ProductEntity> findById(String item_code);
}
