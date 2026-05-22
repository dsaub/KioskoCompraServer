package com.kiosko.server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "tickets")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id private Long id;
    private Date created_at;

    @OneToMany(mappedBy = "ticket_item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketItem> items;
}
