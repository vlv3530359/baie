package com.baie.controller;

import com.baie.core.entity.Product;
import com.baie.core.module.ProductData;
import com.baie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, allowCredentials = "true")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public String saveProduct(@RequestBody ProductData productData) {
        if (productService.saveProduct(productData)) {
            return "Save product successfully.";
        } else {
            return "Save product failed.";
        }
    }

    @PostMapping("/save/all")
    public String saveAllProduct() {
        if (productService.saveAllProductInSearchEngine()) {
            return "Save product successfully.";
        } else {
            return "Save product failed.";
        }
    }

    @PostMapping("/delete")
    public String deleteProduct() {
        return "Save product failed.";
    }

    @PostMapping("/update")
    public String updateProduct() {
        return "Save product failed.";
    }

    @GetMapping("/find/{id}")
    public Product findProductById(@PathVariable Long id) throws InterruptedException {

        //Thread.sleep(6000);
        Product product = productService.findProductById(id);

        return product;
    }

    @GetMapping("/find/all")
    public List<ProductData> findAllProduct(HttpServletRequest request) throws InterruptedException {
        //Special address the null term, we can't set it as null, else there is a Feign exception
        //We will address it in future
        String term = request.getParameter("term") == null ? "null" : request.getParameter("term");
        int page = Integer.valueOf(request.getParameter("page"));
        int pageSize = Integer.valueOf(request.getParameter("pageSize"));
        boolean orderFlag = Boolean.valueOf(request.getParameter("orderFlag"));
        String categoryId = request.getParameter("categoryId");
        //Thread.sleep(6000);
        List<ProductData> productDataList = productService.findAllProduct(term, page, pageSize, categoryId);

        return productDataList;
    }


    @GetMapping("/query")
    public List<Product> queryProducts() {
        return new ArrayList<>();
    }
}
