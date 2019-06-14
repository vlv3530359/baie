package com.baie.core.module;

import com.baie.core.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product", type = "product")
public class ProductData implements Serializable {
    @Id
    private Long id;

    private String productName;

    private String longDescription;

    private String categoryId;

    private Integer productPrice;

    private String productImg;

    public Product buildProduct() {
        return Product.builder().productId(id).categoryId(this.categoryId).productImg(productImg).productPrice(productPrice).productName(this.productName).longDescription(this.longDescription).build();
    }

}
