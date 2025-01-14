package com.example.Spring.product.Model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }
}
