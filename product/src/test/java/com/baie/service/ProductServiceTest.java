package com.baie.service;

import com.baie.ProductApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ProductApplication.class)
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @Test
    public void testSave() {
        ProductData productData = ProductData.builder().displayName("productName").categoryId("1001").longDescription("long description").build();
        boolean result = productService.saveProduct(productData);
        assertTrue(result);

    }

}
