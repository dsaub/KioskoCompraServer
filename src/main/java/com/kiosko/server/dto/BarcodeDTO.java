package com.kiosko.server.dto;

import com.kiosko.server.models.Barcode;
import lombok.Data;

@Data
public class BarcodeDTO {
    private Long id;
    private String barcode;

    public BarcodeDTO(Barcode barcode) {
        id = barcode.getId();
        this.barcode = barcode.getBarcode();
    }
}
