package com.baie.product.controller;

import com.baie.product.entity.Product;
import com.baie.product.module.ProductData;
import com.baie.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
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

        Thread.sleep(6000);
        Product product = productService.findProductById(id);

        return product;
    }

    @GetMapping("/query")
    public List<Product> queryProducts() {
        return new ArrayList<>();
    }
}
