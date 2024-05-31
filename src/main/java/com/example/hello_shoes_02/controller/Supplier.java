package com.example.hello_shoes_02.controller;

import com.example.hello_shoes_02.dto.CustomerDTO;
import com.example.hello_shoes_02.dto.SupplierDTO;
import com.example.hello_shoes_02.entity.CustomerEntity;
import com.example.hello_shoes_02.entity.SupplierEntity;
import com.example.hello_shoes_02.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
@RequiredArgsConstructor
@CrossOrigin
public class Supplier {
    private final SupplierService supplierService;

    @GetMapping("/health")
    public String healthCheck(){
        return "supplier HealthCheck success";
    }

    @PostMapping("/addsupplier")
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplier){
        return supplierService.saveSupplier(supplier);
    }

    @GetMapping("/getallsupplier")
    public List<SupplierDTO> getAllSupplier(){
        return supplierService.getAllSupplier();
    }

    @DeleteMapping("/deletesupplier/{supplierId}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String supplierId){
        supplierService.deleteSupplier(supplierId);
        return ResponseEntity.ok("Supplier deleted successfully");
    }

    @GetMapping("/selectsupplier/{supplierId}")
    public ResponseEntity<SupplierDTO>getSelectedSupplier(@PathVariable String supplierId){
        SupplierDTO supplier = supplierService.getSelectedSupplier(supplierId);
        if(supplier != null){
            return ResponseEntity.ok(supplier);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<SupplierEntity> updateSupplier(@PathVariable String supplierId,
                                                         @RequestBody SupplierDTO updatedSupplier){
        SupplierEntity supplier = supplierService.updateSupplier(supplierId,updatedSupplier);
        if(supplier != null){
            return ResponseEntity.ok(supplier);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
