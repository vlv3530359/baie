package com.baie.search.repository;

import com.baie.search.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductRepository")
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
