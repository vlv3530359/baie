package com.baie.service;

import com.baie.core.module.ProductData;
import com.baie.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public boolean addProduct(ProductData productData) {
        log.info("Add product in search engine: " + productData);
        return save(productData);
    }

    public boolean deleteProduct(Long id) {
        log.info("Delete product in search engine: " + id);
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Delete product in search engine with error: ", e);
            return false;
        }
    }

    public boolean deleteAll() {
        log.info("Delete all products in search engine.");
        try {
            productRepository.deleteAll();
            return true;
        } catch (Exception e) {
            log.error("Delete all products in search engine with error: ", e);
            return false;
        }
    }

    public List<ProductData> findAll(String term, int page, int size, String categoryId) {
        List<ProductData> productDataList = new ArrayList<>();

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        if (!"null".equalsIgnoreCase(term)) {
            queryBuilder.withQuery(
                    QueryBuilders.boolQuery()
                            .should(QueryBuilders.matchQuery("productName", term))
                            .should(QueryBuilders.matchQuery("longDescription", term))
            );
        }
        if (!"all".equalsIgnoreCase(categoryId)) {
            queryBuilder.withQuery(
                    QueryBuilders.boolQuery()
                            .should(QueryBuilders.matchQuery("categoryId", categoryId))
            );
        }
        queryBuilder.withSort(SortBuilders.scoreSort());
        queryBuilder.withPageable(PageRequest.of(page,size));
        Iterable<ProductData> iterable = productRepository.search(queryBuilder.build());

        for(ProductData item: iterable) {
            productDataList.add(item);
        }
        return productDataList;

    }

    public Optional<ProductData> queryById(Long id) {
         return productRepository.findById(id);
    }

    public boolean update(ProductData productData) {
        log.info("Update product in search engine: " + productData);
        Optional<ProductData> originalProduct = productRepository.findById(productData.getId());
        return originalProduct.map(i->save(productData)).orElse(false);
    }

    public Iterable<ProductData> queryByTermAndSortWithPaging(String property, String value) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.termQuery(property, value));
        //queryBuilder.withSort(SortBuilders.fieldSort(property).order(SortOrder.ASC));
        queryBuilder.withSort(SortBuilders.scoreSort());
        queryBuilder.withPageable(PageRequest.of(0,12));
        Iterable<ProductData> products = productRepository.search(queryBuilder.build());
        return products;
    }

    public Iterable<ProductData> queryByBoolean(String value) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(
                QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("productName", value))
                                         .should(QueryBuilders.matchQuery("longDescription", value))

        );
        queryBuilder.withSort(SortBuilders.scoreSort());
        queryBuilder.withPageable(PageRequest.of(0,12));
        Iterable<ProductData> products = productRepository.search(queryBuilder.build());
        return products;
    }

    private boolean save(ProductData productData) {
        try {
            productRepository.save(productData);
            return true;
        } catch (Exception e) {
            log.error("", e);
            return false;
        }
    }


}
