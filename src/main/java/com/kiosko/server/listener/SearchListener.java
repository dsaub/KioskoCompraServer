package com.kiosko.server.listener;

import com.kiosko.server.dto.BarcodeDTO;
import com.kiosko.server.dto.ProductDTO;
import com.kiosko.server.services.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
class SearchListener {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BarcodeService barcodeService;
    @RabbitListener(queuesToDeclare = @Queue(name="barcode.search", durable = "true"))
    public String searchProduct(String rec) {
        BarcodeDTO dto = objectMapper.readValue(rec, BarcodeDTO.class);
        ProductDTO dto2 = barcodeService.getProduct(dto);
        return objectMapper.writeValueAsString(dto2);
    }
}
