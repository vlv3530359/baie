package com.baie.repository;

import com.baie.core.module.ProductData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductRepository")
public interface ProductRepository extends ElasticsearchRepository<ProductData, Long> {
}
