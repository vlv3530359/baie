package com.baie.core.entity;

import com.baie.core.module.ProductData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity implements Serializable {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long                    productId;

    @Column(name = "PRODUCT_NAME")
    private String                    productName;

    @Lob
    @Column(name = "LONG_DESCRIPTION")
    private String                    longDescription;

    @Column(name = "CATEGORY_ID")
    private String                    categoryId;

    @Column(name = "PRODUCT_PRICE")
    private Integer                   productPrice;

    @Column(name="PRODUCT_IMAGE")
    private String                    productImg;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private List<Sku>                 skus;


    public ProductData buildProductData() {
        return ProductData.builder().id(productId).categoryId(categoryId).productName(productName).longDescription(longDescription).productImg(productImg).productPrice(productPrice).build();
    }



}
