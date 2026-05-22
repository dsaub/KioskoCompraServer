package com.kiosko.server.listener;

import com.kiosko.server.dto.VentaDTO;
import com.kiosko.server.services.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class VentaListener {
    private final ObjectMapper objectMapper;
    private final VentaService ventaService;

    @RabbitListener(queues = "kiosko.ventas")
    public void procesarMensajeDelKiosko(String jsonCrudo) {
        try {
            VentaDTO venta = objectMapper.readValue(jsonCrudo, VentaDTO.class);
            ventaService.procesarVentaConsolidada(venta);
        } catch (Exception e) {
            System.err.println("Error al procesar el mensaje entrante: " + e.getMessage());
        }
    }
}
