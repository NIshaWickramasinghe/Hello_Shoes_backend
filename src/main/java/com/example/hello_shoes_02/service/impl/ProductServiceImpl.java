package com.example.hello_shoes_02.service.impl;

import com.example.hello_shoes_02.dao.ProductRepo;
import com.example.hello_shoes_02.dto.ProductDTO;
import com.example.hello_shoes_02.entity.ProductEntity;
import com.example.hello_shoes_02.service.ProductService;
import com.example.hello_shoes_02.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo repo;
    private final Mapping mapping;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return mapping.toProductDTO(repo.save(mapping.toProduct(productDTO)));
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return mapping.toProductDTOList(repo.findAll());
    }

    @Override
    public void deleteProduct(String productId) {
        repo.deleteById(productId);
    }

    @Override
    public ProductDTO getSelectedProduct(String productId) {
        Optional<ProductEntity> optionalProduct = repo.findById(productId);
        return optionalProduct.map(mapping::toProductDTO).orElse(null);
    }

    @Override
    public ProductEntity updateProduct(String id, ProductDTO updatedProduct) {

        Optional<ProductEntity> optionalProduct = repo.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity existingProduct = optionalProduct.get();

            existingProduct.setItem_code(updatedProduct.getItem_code());
            existingProduct.setItem_desc(updatedProduct.getItem_desc());
            existingProduct.setItem_picture(updatedProduct.getItem_picture());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setSize(updatedProduct.getSize());
            existingProduct.setSale_price(updatedProduct.getSale_price());
            existingProduct.setExpected_profit(updatedProduct.getExpected_profit());
            existingProduct.setProfit_margin(updatedProduct.getProfit_margin());
            existingProduct.setStatus(updatedProduct.getStatus());

            return repo.save(existingProduct);
        } else {
            return null;
        }
    }
}

