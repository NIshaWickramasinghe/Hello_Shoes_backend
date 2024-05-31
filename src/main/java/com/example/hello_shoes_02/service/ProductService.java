package com.example.hello_shoes_02.service;

import com.example.hello_shoes_02.dto.ProductDTO;
import com.example.hello_shoes_02.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO>getAllProduct();
    void deleteProduct(String productId);
    ProductDTO getSelectedProduct(String productId);
    ProductEntity updateProduct(String id,ProductDTO updatedProduct);
}
