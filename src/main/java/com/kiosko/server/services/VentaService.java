package com.kiosko.server.services;

import com.kiosko.server.dto.VentaDTO;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    public void procesarVentaConsolidada(VentaDTO venta) {
        System.out.println("--- LOGICA DE SERVICIO EN BACKEND ---");
        System.out.println("Guardando en el sistema central la venta ID: " + venta.getId());
        System.out.println("Validando stock global para: " + venta.getProducto());
        System.out.println("Monto procesado: $" + venta.getTotal());
        System.out.println("-------------------------------------");
    }
}
