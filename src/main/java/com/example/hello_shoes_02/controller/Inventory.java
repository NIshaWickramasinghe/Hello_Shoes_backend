package com.example.hello_shoes_02.controller;

import com.example.hello_shoes_02.dto.InventoryDTO;
import com.example.hello_shoes_02.entity.InventoryEntity;
import com.example.hello_shoes_02.service.InventoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin
public class Inventory {
    private final InventoryServices inventoryServices;

    @GetMapping("/health")
    public String healthCheck(){
        return "inventory HealthCheck success";
    }

    @PostMapping("/addstock")
    public InventoryDTO saveStock(@RequestBody InventoryDTO inventory){
        return inventoryServices.saveStock(inventory);
    }

    @GetMapping("/getallstocks")
    public List<InventoryDTO> getAllStock(){
        return inventoryServices.getAllStocks();
    }

    @DeleteMapping("/deletestock/{stockId}")
    public ResponseEntity<String> deleteStock (@PathVariable String stockId){
        InventoryDTO inventory = inventoryServices.getSelectedStock(stockId);
        inventoryServices.deleteStock(stockId);
        return ResponseEntity.ok("Stock deleted successfully");
    }

    @GetMapping("/selectstock/{stockId}")
    public ResponseEntity<InventoryDTO> getSelectedStock (@PathVariable String stockId){
        InventoryDTO inventory = inventoryServices.getSelectedStock(stockId);
        if (inventory != null){
            return ResponseEntity.ok(inventory);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{stockId}")
    public ResponseEntity<InventoryEntity> updateStock (@PathVariable String stockId,
                                                        @RequestBody InventoryDTO updatedstock){
        InventoryEntity inventory = inventoryServices.updateStock(stockId,updatedstock);
        if (inventory != null){
            return ResponseEntity.ok(inventory);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
