package com.kiosko.server.services;

import com.kiosko.server.dto.BarcodeDTO;
import com.kiosko.server.dto.ProductDTO;
import com.kiosko.server.models.Barcode;
import com.kiosko.server.models.Product;
import com.kiosko.server.repository.ProductRepository;
import com.kiosko.server.exceptions.ProductNotFound;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class ProductService {
    private final ProductRepository productRepository;
    private Logger logger = LoggerFactory.getLogger(ProductService.class);
    public Product fromDto(ProductDTO productDTO) throws ProductNotFound {
        Optional<Product> productOptional = productRepository.findById(productDTO.getId());
        if (productOptional.isEmpty()) {
            logger.info("Product with id " + productDTO.getId() + " not found, creating one (without saving)");
            Product product = new Product();
            product.setBarcodes(new ArrayList<>());
            product.setName(productDTO.getName());
            product.setStock(productDTO.getStock());
            product.setPrice(productDTO.getPrice());
            return product;
        }
        return productOptional.get();
    }

    public BarcodeDTO[] getBarcodes(ProductDTO productDTO) {
        ArrayList<BarcodeDTO> barcodeDTOArrayList = new ArrayList<BarcodeDTO>();

        Product product = fromDto(productDTO);
        List<Barcode> barcodeList = product.getBarcodes();
        for (Barcode barcode : barcodeList) {
            barcodeDTOArrayList.add(new BarcodeDTO(barcode));
        }
        return (BarcodeDTO[]) barcodeDTOArrayList.toArray();
    }


    // TODO: Make Product Search by barcode function
}
