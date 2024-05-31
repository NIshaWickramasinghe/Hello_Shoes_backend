package com.example.hello_shoes_02.service;

import com.example.hello_shoes_02.dto.SupplierDTO;
import com.example.hello_shoes_02.entity.SupplierEntity;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    List<SupplierDTO>getAllSupplier();
    void deleteSupplier(String supplierId);
    SupplierDTO getSelectedSupplier(String supplierId);
    SupplierEntity updateSupplier(String id, SupplierDTO updatedSupplier);
}
