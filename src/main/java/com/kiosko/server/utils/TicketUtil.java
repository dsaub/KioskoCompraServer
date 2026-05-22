package com.kiosko.server.utils;

import com.kiosko.server.models.Product;
import com.kiosko.server.models.Ticket;
import com.kiosko.server.models.TicketItem;

import java.util.List;

public class TicketUtil {

    public static float calculateTicketTotal(Ticket ticket) {
        float total = 0;
        List<TicketItem> items = ticket.getItems();
        for (TicketItem item : items) {
            Product product = item.getProduct();
            total += (product.getPrice() * item.getQuantity());
        }

        return total;
    }

    // TODO: Make DTO-Param alternative to #calculateTicketTotal(Ticket ticket) here.
}
