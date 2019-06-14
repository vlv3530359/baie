package com.baie.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CAR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long                    id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product                    product;

    @Column(name = "price")
    private Integer                 price;

    @Column(name = "count")
    private Integer                 count;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User                    user;
}
