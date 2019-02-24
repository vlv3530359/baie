package com.baie.search.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "brand", type = "brand", shards = 7, replicas = 1)
public class Brand {
    @Id
    private String id;

    private String title;

    private String name;

    private String description;
}
