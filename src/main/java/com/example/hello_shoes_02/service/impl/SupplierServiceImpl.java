package com.example.hello_shoes_02.service.impl;

import com.example.hello_shoes_02.dao.SupplierRepo;
import com.example.hello_shoes_02.dto.SupplierDTO;
import com.example.hello_shoes_02.entity.SupplierEntity;
import com.example.hello_shoes_02.service.SupplierService;
import com.example.hello_shoes_02.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepo repo;
    private final Mapping mapping;
    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        return mapping.toSupplierDTO(repo.save(mapping.toSupplier(supplierDTO)));
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return mapping.toSupplierDTOList(repo.findAll());
    }

    @Override
    public void deleteSupplier(String supplierId) {
        repo.deleteById(supplierId);
    }

    @Override
    public SupplierDTO getSelectedSupplier(String supplierId) {
        Optional<SupplierEntity> optionalSupplier = repo.findById(supplierId);
        return optionalSupplier.map(mapping::toSupplierDTO).orElse(null);
    }

    @Override
    public SupplierEntity updateSupplier(String id, SupplierDTO updatedSupplier) {
        Optional<SupplierEntity> optionalSupplier = repo.findById(id);
        if (optionalSupplier.isPresent()) {
            SupplierEntity existingSupplier = optionalSupplier.get();

            existingSupplier.setSupplierCode(updatedSupplier.getSupplierCode());
            existingSupplier.setSup_name(updatedSupplier.getSup_name());
            existingSupplier.setCategory(updatedSupplier.getCategory());
            existingSupplier.setMobile(updatedSupplier.getMobile());
            existingSupplier.setLandLine(updatedSupplier.getLandLine());
            existingSupplier.setEmail(updatedSupplier.getEmail());
            existingSupplier.setBuilding_no(updatedSupplier.getBuilding_no());
            existingSupplier.setLane(updatedSupplier.getLane());
            existingSupplier.setCity(updatedSupplier.getCity());
            existingSupplier.setState(updatedSupplier.getState());
            existingSupplier.setPostal_code(updatedSupplier.getPostal_code());
            existingSupplier.setCountry(updatedSupplier.getCountry());

            return repo.save(existingSupplier);
        } else {
            return null;
        }
    }
}
