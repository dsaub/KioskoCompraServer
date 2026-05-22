package com.kiosko.server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "barcodes")
public class Barcode {
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private Long id;
    private String barcode;

    @ManyToOne()
    @JoinColumn(name = "products_id")
    private Product product;
}
