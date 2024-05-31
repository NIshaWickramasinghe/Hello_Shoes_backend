package com.example.hello_shoes_02.service.impl;

import com.example.hello_shoes_02.dao.InventoryRepo;
import com.example.hello_shoes_02.dto.InventoryDTO;
import com.example.hello_shoes_02.entity.InventoryEntity;
import com.example.hello_shoes_02.service.InventoryServices;
import com.example.hello_shoes_02.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryServices {
    private final InventoryRepo repo;
    private final Mapping mapping;
    @Override
    public InventoryDTO saveStock(InventoryDTO inventoryDTO) {
        return mapping.toInventoryDTO(repo.save(mapping.toInventory(inventoryDTO)));
    }

    @Override
    public List<InventoryDTO> getAllStocks() {
        return mapping.toInventoryDTOList(repo.findAll());
    }

    @Override
    public void deleteStock(String stockId) {
        repo.deleteById(stockId);
    }

    @Override
    public InventoryDTO getSelectedStock(String stockId) {
        Optional<InventoryEntity> optionalInventory = repo.findById(stockId);
        return optionalInventory.map(mapping::toInventoryDTO).orElse(null);
    }

    @Override
    public InventoryEntity updateStock(String id, InventoryDTO updatedStock) {
        Optional<InventoryEntity> optionalInventory = repo.findById(id);
        if(optionalInventory.isPresent()){
            InventoryEntity existingStock = optionalInventory.get();

            existingStock.setStockId(updatedStock.getStockId());
            existingStock.setQty(updatedStock.getQty());
            existingStock.setMax_qty(updatedStock.getMax_qty());
            existingStock.setSize(updatedStock.getSize());
            existingStock.setLastDate(updatedStock.getLastDate());
            existingStock.setNextDate(updatedStock.getNextDate());
            existingStock.setBuy_price(updatedStock.getBuy_price());

            return repo.save(existingStock);
        }else {
            return null;
        }

    }
}
