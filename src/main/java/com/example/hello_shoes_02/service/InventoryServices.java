package com.example.hello_shoes_02.service;

import com.example.hello_shoes_02.dto.InventoryDTO;
import com.example.hello_shoes_02.entity.InventoryEntity;

import java.util.List;

public interface InventoryServices {
    InventoryDTO saveStock(InventoryDTO inventoryDTO);
    List<InventoryDTO> getAllStocks();
    void deleteStock(String stockId);
    InventoryDTO getSelectedStock(String stockId);
    InventoryEntity updateStock(String id, InventoryDTO updatedStock);
}
