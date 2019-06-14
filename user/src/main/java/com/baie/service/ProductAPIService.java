package com.baie.service;

import com.baie.core.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name="GATEWAY-SERVER")
public interface ProductAPIService {
    @RequestMapping(value = "/apiproduct/product/find/{id}",method = RequestMethod.GET)
    public Product findProductById(@PathVariable("id") Long id);
}
