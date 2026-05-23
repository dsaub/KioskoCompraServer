package com.kiosko.server.services;

import com.kiosko.server.dto.ProductDTO;
import com.kiosko.server.models.Product;
import com.kiosko.server.repository.ProductRepository;
import com.kiosko.server.exceptions.ProductNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class ProductService {
    private final ProductRepository productRepository;

    public Product fromDto(ProductDTO productDTO) throws ProductNotFound {
        Optional<Product> productOptional = productRepository.findById(productDTO.getId());
        if (productOptional.isEmpty()) throw new ProductNotFound("Product with id " + productDTO.getId() + " not found");
        return productOptional.get();
    }
    // TODO: Make Product Search by barcode function
}
