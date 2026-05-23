package com.kiosko.server.services;

import com.kiosko.server.dto.BarcodeDTO;
import com.kiosko.server.dto.ProductDTO;
import com.kiosko.server.exceptions.BarcodeNotFound;
import com.kiosko.server.models.Barcode;
import com.kiosko.server.models.Product;
import com.kiosko.server.repository.BarcodeRepository;
import com.kiosko.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarcodeService {
    private final BarcodeRepository barcodeRepository;
    private final ProductRepository productRepository;

    public Barcode getBarcode(BarcodeDTO dto) throws BarcodeNotFound {
        Optional<Barcode> barcodeOptional = barcodeRepository.findById(dto.getId());
        if (barcodeOptional.isEmpty()) throw new BarcodeNotFound("Barcode with id " + dto.getId() + " not found");
        return barcodeOptional.get();
    }

    public ProductDTO getProduct(BarcodeDTO dto) {
        Barcode barcode = getBarcode(dto);
        return new ProductDTO(barcode.getProduct());
    }
}
