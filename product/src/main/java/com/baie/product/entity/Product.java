package com.baie.product.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DCS_PRODUCT")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private String                    productId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "DISPLAY_NAME")
    private String                    displayName;

    @Lob
    @Column(name = "LONG_DESCRIPTION")
    private String                    longDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(table = "FBL_PRODUCT", name = "LAST_MOD_DATE")
    private Date                      lastModifiedDate;



}
