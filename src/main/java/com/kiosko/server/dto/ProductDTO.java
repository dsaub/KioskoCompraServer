package com.kiosko.server.dto;

import com.kiosko.server.models.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private float price;
    private int stock;

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        stock = product.getStock();
    }
}
