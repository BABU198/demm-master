package com.programmingtechie.product_service.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

public class Product {


    public static JsonSubTypes.Type builder() {
        return null;
    }

    public String getId() {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public BigDecimal getPrice() {
        return null;
    }

    @Document(value = "product")
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public class product {
        @Id
        private String id;
        private String name;
        private String description;
        private BigDecimal price;

    }
}
