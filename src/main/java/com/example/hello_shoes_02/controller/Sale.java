package com.example.hello_shoes_02.controller;

import com.example.hello_shoes_02.dto.CustomerDTO;
import com.example.hello_shoes_02.dto.SaleDTO;
import com.example.hello_shoes_02.entity.CustomerEntity;
import com.example.hello_shoes_02.entity.SaleEntity;
import com.example.hello_shoes_02.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sale")
@RequiredArgsConstructor
@CrossOrigin
public class Sale {
    private final SaleService saleService;

    @GetMapping("/health")
    public String healthCheck(){
        return "sale HealthCheck success";
    }

    @PostMapping("/addsale")
    public SaleDTO saveSale(@RequestBody SaleDTO sale){
        return saleService.saveSale(sale);
    }

    @GetMapping("/getallsales")
    public List<SaleDTO> getAllSales(){
        return saleService.getAllSales();
    }

    @DeleteMapping("/deletesale/{saleId}")
    public ResponseEntity<String> deleteSale (@PathVariable String saleId){
        saleService.deleteSale(saleId);
        return ResponseEntity.ok("Sale deleted successfully");
    }

    @GetMapping("/selectedsale/{saleId}")
    public ResponseEntity<SaleDTO>getSelectedSale(@PathVariable String saleId){
        SaleDTO sale = saleService.getSelectedSale(saleId);
        if(sale != null){
            return ResponseEntity.ok(sale);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{saleId}")
    public ResponseEntity<SaleEntity> updateSale(@PathVariable String saleId,
                                                     @RequestBody SaleDTO updatedSale){
        SaleEntity sale = saleService.updateSale(saleId,updatedSale);
        if(sale != null){
            return ResponseEntity.ok(sale);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
