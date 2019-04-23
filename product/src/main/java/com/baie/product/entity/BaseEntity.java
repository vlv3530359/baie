package com.baie.product.entity;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

public class BaseEntity {
    @Column(name = "CREATED_BY")
    private String                    createdBy;

    @Column(name = "UPDATE_BY")
    private String                    updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date                      creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MOD_DATE")
    private Date                      lastModifiedDate;

    @Version
    @Column(name = "VERSION")
    private Integer                   version;
}
