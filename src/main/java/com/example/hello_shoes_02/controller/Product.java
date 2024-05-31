package com.example.hello_shoes_02.controller;

import com.example.hello_shoes_02.dto.ProductDTO;
import com.example.hello_shoes_02.entity.ProductEntity;
import com.example.hello_shoes_02.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
@CrossOrigin
public class Product {
    private final ProductService productService;

    @GetMapping("/health")
    public String healthCheck(){
        return "product HealthCheck success";
    }

    @PostMapping("/addproduct")
    public ProductDTO saveProduct(@RequestBody ProductDTO product){
        return  productService.saveProduct(product);
    }

    @GetMapping("/getallproduct")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted Successfully");
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getSelectedProduct(@PathVariable String productId){
        ProductDTO product = productService.getSelectedProduct(productId);
        if (product != null){
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String productId ,
                                                       @RequestBody ProductDTO updatedProduct){
        ProductEntity product = productService.updateProduct(productId,updatedProduct);
        if (product != null){
            return ResponseEntity.ok(product);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
