package com.baie.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SKU")
@NamedQuery(name = "Sku.findAll", query = "SELECT d FROM Sku d")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sku extends BaseEntity implements Serializable {
    @Id
    @Column(name = "ID")
    private String                id;

    @Column(name = "DISPLAY_NAME")
    private String                displayName;

    @Lob
    @Column(name = "LONG_DESCRIPTION")
    private String                longDescription;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
    private Product               product;

}
