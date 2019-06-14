package com.baie.core.entity;

import javax.persistence.*;
import java.util.Date;
@MappedSuperclass
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
