package com.kiosko.server.repository;

import com.kiosko.server.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

interface TicketRepository extends JpaRepository<Ticket, Long> {
}
