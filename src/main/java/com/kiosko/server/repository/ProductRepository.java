package com.kiosko.server.repository;

import com.kiosko.server.models.Product;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
