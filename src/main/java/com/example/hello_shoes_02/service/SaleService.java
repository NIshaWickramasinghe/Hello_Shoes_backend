package com.example.hello_shoes_02.service;

import com.example.hello_shoes_02.dto.SaleDTO;
import com.example.hello_shoes_02.entity.SaleEntity;

import java.util.List;

public interface SaleService {
    SaleDTO saveSale(SaleDTO saleDTO);
    List<SaleDTO>getAllSales();
    void deleteSale(String saleId);
    SaleDTO getSelectedSale(String saleId);
    SaleEntity updateSale(String id,SaleDTO updatedSale);
}
