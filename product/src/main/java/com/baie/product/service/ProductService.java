package com.baie.product.service;

import com.baie.product.entity.Product;
import com.baie.product.module.ProductData;
import com.baie.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean saveProduct(ProductData productData) {
        try {
            Product product = productData.buildProduct();
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            log.error("ProductService.saveProduct error: ", e);
            return false;
        }
    }

    public Product findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
