package com.baie.search.service;

import com.baie.search.entity.Product;
import com.baie.search.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public boolean addProduct(Product product) {
        log.info("Add product: " + product);
        return save(product);
    }

    public boolean deleteProduct(String id) {
        log.info("Delete product: " + id);
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Delete product with error: ", e);
            return false;
        }
    }

    public boolean deleteAll() {
        log.info("Delete all products.");
        try {
            productRepository.deleteAll();
            return true;
        } catch (Exception e) {
            log.error("Delete all products with error: ", e);
            return false;
        }
    }

    public Optional<Product> queryById(String id) {
         return productRepository.findById(id);
    }

    public boolean update(Product product) {
        log.info("Update product: " + product);
        Optional<Product> originalProduct = productRepository.findById(product.getId());
        return originalProduct.map(i->save(product)).orElse(false);
    }

    public Iterable<Product> queryByTermAndSortWithPaging(String property, String value) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.termQuery(property, value));
        //queryBuilder.withSort(SortBuilders.fieldSort(property).order(SortOrder.ASC));
        queryBuilder.withSort(SortBuilders.scoreSort());
        queryBuilder.withPageable(PageRequest.of(0,12));
        Iterable<Product> products = productRepository.search(queryBuilder.build());
        return products;
    }

    public Iterable<Product> queryByBoolean(String value) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(
                QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", value))
                                         .should(QueryBuilders.matchQuery("title", value))
                                         .should(QueryBuilders.matchQuery("description", value))
        );
        queryBuilder.withSort(SortBuilders.scoreSort());
        queryBuilder.withPageable(PageRequest.of(0,12));
        Iterable<Product> products = productRepository.search(queryBuilder.build());
        return products;
    }

    private boolean save(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
