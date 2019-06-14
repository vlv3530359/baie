package com.baie.service;

import com.baie.core.entity.Product;
import com.baie.core.integration.IntegrationAPIService;
import com.baie.core.module.ProductData;
import com.baie.core.utils.JsonUtils;
import com.baie.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Value("${fromDbFlag}")
    private boolean fromDBFlag = false;

    @Autowired
    IntegrationAPIService integrationAPIService;

    public boolean saveProduct(ProductData productData) {
        try {
            Product product = productData.buildProduct();
            productRepository.save(product);
            integrationAPIService.sendMessage(product);
            return true;
        } catch (Exception e) {
            log.error("ProductService.saveProduct error: ", e);
            return false;
        }
    }

    public boolean saveAllProductInSearchEngine() {
        List<Product> allProduct = productRepository.findAll();
        Optional<Product> failedProductOptional = allProduct.stream().filter(i->"false".equalsIgnoreCase(integrationAPIService.sendMessage(i))).findFirst();
        return failedProductOptional.map(i->false).orElse(true);
    }

    public Product findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public List<ProductData> findAllProduct(String term, int page, int size, String categoryId) {

        if (fromDBFlag) {
            return findProductFromDB();
        } else {
            return findProductFromSearchEngine(term, page, size, categoryId);
        }

    }

    public List<ProductData> findProductFromSearchEngine(String term, int page, int size, String categoryId) {
        String responseStr = integrationAPIService.findAllProductInSearchEngine(term, page, size, categoryId);
        List<ProductData> list = null;
        try {
            list = (List<ProductData>) JsonUtils.jsonToObj(List.class, responseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ProductData> findProductFromDB() {
        List<ProductData> productDataList = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        products.stream().forEach(i->productDataList.add(i.buildProductData()));
        return productDataList;
    }
}
