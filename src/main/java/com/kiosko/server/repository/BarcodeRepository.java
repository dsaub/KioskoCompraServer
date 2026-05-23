package com.kiosko.server.repository;

import com.kiosko.server.models.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;

interface BarcodeRepository extends JpaRepository<Barcode, Long> {
}
