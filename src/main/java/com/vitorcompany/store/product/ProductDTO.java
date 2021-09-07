package com.vitorcompany.store.product;

import java.math.BigDecimal;

public class ProductDTO {
    String id;
    String name;
    String description;
    Double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice().doubleValue();
    }

    public ProductDTO(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
