package com.baie.controller;


import com.baie.core.entity.Product;
import com.baie.core.module.ProductData;
import com.baie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/search/product")
public class SearchProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product) {
        ProductData productData = product.buildProductData();
        if (productService.addProduct(productData)) {
            return "Save product in search engine successfully.";
        } else {
            return "Save product in search engine failed.";
        }
    }

    @GetMapping("/find/all")
    public List<ProductData> findAllProduct(@RequestParam("term") String term, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("categoryId") String categoryId) {
        return productService.findAll(term, page, size, categoryId);
    }
}
