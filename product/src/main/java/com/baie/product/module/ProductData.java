package com.baie.product.module;

import com.baie.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductData implements Serializable {

    private String displayName;

    private String longDescription;

    private String categoryId;

    public Product buildProduct() {
        return Product.builder().categoryId(this.categoryId).displayName(this.displayName).longDescription(this.longDescription).build();
    }

}
