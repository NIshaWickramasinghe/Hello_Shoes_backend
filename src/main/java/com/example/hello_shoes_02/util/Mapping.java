package com.example.hello_shoes_02.util;


import com.example.hello_shoes_02.dto.*;
import com.example.hello_shoes_02.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;



    //CustomerEntity type to CustomerDTO
    public CustomerDTO toCustomerDTO(CustomerEntity customer){
        return mapper.map(customer,CustomerDTO.class);
    }

    //CustomerDTO type to CustomerEntity
    public CustomerEntity toCustomer(CustomerDTO customerDTO){return mapper.map(customerDTO,CustomerEntity.class);}


    //A list of CustomerEntity to CustomerDTO
    public List<CustomerDTO>toCustomerDTOList(List<CustomerEntity> customers){
        return mapper.map(customers,List.class);
    }

    //EmployeeEntity type to EmployeeDTO
    public EmployeeDTO toEmployeeDTO(EmployeeEntity employee){
        return mapper.map(employee,EmployeeDTO.class);
    }

    //EmployeeDTO type to EmployeeEntity
    public EmployeeEntity toEmployee(EmployeeDTO employeeDTO){
        return mapper.map(employeeDTO,EmployeeEntity.class);
    }

    //A list of Employeeentity to EmployeeDTO
    public List<EmployeeDTO>toEmployeeDTOList(List<EmployeeEntity> employees){
        return mapper.map(employees,List.class);
    }

    //ProductEntity type to ProductDTO
    public ProductDTO toProductDTO(ProductEntity product){
        return mapper.map(product,ProductDTO.class);
    }

    //ProductDTO type to productEntity type
    public ProductEntity toProduct(ProductDTO productDTO){
        return mapper.map(productDTO,ProductEntity.class);
    }

    //A list of ProductEntity to productDTO
    public List<ProductDTO> toProductDTOList(List<ProductEntity> products){
        return mapper.map(products,List.class);
    }

    //SaleEntity type to SaleDTO
    public SaleDTO toSaleDTO(SaleEntity sale){
        return mapper.map(sale,SaleDTO.class);
    }

    //SaleDTO type to SaleEntity
    public SaleEntity toSale(SaleDTO saleDTO){
        return mapper.map(saleDTO,SaleEntity.class);
    }

    //A List of saleEntity to SaleDTO
    public List<SaleDTO>toSaleDTOList(List<SaleEntity> sales){
        return mapper.map(sales,List.class);
    }

    //SupplierEntity type to SupplierDTO
    public SupplierDTO toSupplierDTO(SupplierEntity supplier){
        return mapper.map(supplier,SupplierDTO.class);
    }

    //SupplierDTO type to SupplierEntity
    public SupplierEntity toSupplier(SupplierDTO supplierDTO){
        return mapper.map(supplierDTO,SupplierEntity.class);
    }

    //A list of SupplierEntity to SupplierDTO
    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> suppliers){
        return mapper.map(suppliers,List.class);
    }

    //InventoryEntity type to InventoryDTO
    public InventoryDTO toInventoryDTO(InventoryEntity inventory){
        return mapper.map(inventory,InventoryDTO.class);
    }

    //InventoryDTO type to InventoryEntity
    public InventoryEntity toInventory(InventoryDTO inventoryDTO){
        return mapper.map(inventoryDTO,InventoryEntity.class);
    }

    //A list of InventoryEntity to InventoryDTO
    public List<InventoryDTO> toInventoryDTOList(List<InventoryEntity> inventories){
        return mapper.map(inventories,List.class);
    }
}
