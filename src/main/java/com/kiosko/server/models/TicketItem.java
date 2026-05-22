package com.kiosko.server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ticket_item")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(name="tickets_id")
    private Ticket ticket;

    @ManyToOne()
    @JoinColumn(name="products_id")
    private Product product;

    private int quantity;
}
