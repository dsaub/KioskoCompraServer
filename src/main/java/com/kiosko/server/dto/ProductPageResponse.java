package com.kiosko.server.dto;

import com.kiosko.server.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPageResponse {
    private List<ProductDTO> content;
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private boolean isLast;

    public static ProductPageResponse fromProduct(
            List<Product> productList,
            int currentPage,
            int totalPages,
            long totalElements,
            boolean isLast
    ) {
        ArrayList<ProductDTO> productDTOArrayList = new ArrayList<>();
        for (Product product : productList) {
            productDTOArrayList.add(new ProductDTO(product));
        }
        return new ProductPageResponse(
                productDTOArrayList,
                currentPage,
                totalPages,
                totalElements,
                isLast
        );

    }

}
