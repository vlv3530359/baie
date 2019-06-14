package com.baie.repository;

import com.baie.entity.Brand;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository("BrandRepository")
public interface BrandRepository extends ElasticsearchRepository<Brand, String> {
}
