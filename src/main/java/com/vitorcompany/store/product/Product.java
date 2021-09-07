package com.vitorcompany.store.product;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String name;
    String description;
    BigDecimal price;

    public Product() {
    }

    public Product(String id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(ProductDTO productDTO) {
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.price = new BigDecimal(productDTO.getPrice());
    }

    public Product(String id, ProductDTO productDTO) {
        this.id = id;
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.price = new BigDecimal(productDTO.getPrice());
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

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice());
    }
}
