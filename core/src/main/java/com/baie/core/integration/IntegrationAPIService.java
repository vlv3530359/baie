package com.baie.core.integration;

import com.baie.core.entity.Product;
import com.baie.core.module.ProductData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="GATEWAY-SERVER")
public interface IntegrationAPIService {
    @RequestMapping(value = "/apiproduct/product/find/{id}",method = RequestMethod.GET)
    public Product findProductById(@PathVariable("id") Long id);

    @RequestMapping(value = "/apimessage/kafka/sendproduct",method = RequestMethod.POST)
    public String sendMessage(Product product);

    @RequestMapping(value = "/apisearch/search/product/save",method = RequestMethod.POST)
    public String saveProductInSearchEngine(Product prodFuct);

    @RequestMapping(value = "/apisearch/search/product/find/all",method = RequestMethod.GET)
    public String findAllProductInSearchEngine(@RequestParam(value="term") String term, @RequestParam(value="page") int page, @RequestParam(value="size") int size, @RequestParam(value="categoryId") String categoryId);
}
