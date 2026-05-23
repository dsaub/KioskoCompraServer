package com.kiosko.server.repository;

import com.kiosko.server.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {

}
