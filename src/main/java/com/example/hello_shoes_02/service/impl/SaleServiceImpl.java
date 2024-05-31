package com.example.hello_shoes_02.service.impl;

import com.example.hello_shoes_02.dao.SaleRepo;
import com.example.hello_shoes_02.dto.SaleDTO;
import com.example.hello_shoes_02.entity.SaleEntity;
import com.example.hello_shoes_02.service.SaleService;
import com.example.hello_shoes_02.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepo repo;
    private final Mapping mapping;

    @Override
    public SaleDTO saveSale(SaleDTO saleDTO) {
        return mapping.toSaleDTO(repo.save(mapping.toSale(saleDTO)));
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return mapping.toSaleDTOList(repo.findAll());
    }

    @Override
    public void deleteSale(String saleId) {
        repo.deleteById(saleId);
    }

    @Override
    public SaleDTO getSelectedSale(String saleId) {
        Optional<SaleEntity> optionalSale = repo.findById(saleId);
        return optionalSale.map(mapping::toSaleDTO).orElse(null);
    }

    @Override
    public SaleEntity updateSale(String id, SaleDTO updatedSale) {
        Optional<SaleEntity> optionalSale = repo.findById(id);
        if(optionalSale.isPresent()){
            SaleEntity existingSale = optionalSale.get();

            existingSale.setOrderId(updatedSale.getOrderId());
            existingSale.setPurchase_date(updatedSale.getPurchase_date());
            existingSale.setTotal_price(updatedSale.getTotal_price());
            existingSale.setAdded_points(updatedSale.getAdded_points());
            existingSale.setPay_method(updatedSale.getPay_method());

            return repo.save(existingSale);
        }else {
            return null;
        }

    }
}
