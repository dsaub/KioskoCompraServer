package com.kiosko.server.repository;

import com.kiosko.server.models.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;

interface TicketItemRepository extends JpaRepository<TicketItem, Long> {
}
