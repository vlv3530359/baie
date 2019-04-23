package com.baie.product.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long                    productId;

    @Column(name = "DISPLAY_NAME")
    private String                    displayName;

    @Lob
    @Column(name = "LONG_DESCRIPTION")
    private String                    longDescription;

    @Column(name = "CATEGORY_ID")
    private String                    categoryId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private List<Sku>                 skus;





}
