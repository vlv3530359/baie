package com.baie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(indexName = "product", type = "product")
public class Product implements Serializable {
    @Id
    private String id;

    private String title;

    @Field(fielddata=true)
    private String name;

    private String description;
}
