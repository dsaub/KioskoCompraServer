package com.kiosko.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO implements Serializable {
    private Long id;
    private String producto;
    private Integer cantidad;
    private BigDecimal total;
}
