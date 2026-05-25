package com.kiosko.server.listener;


import com.kiosko.server.dto.ProductDTO;
import com.kiosko.server.dto.ProductPageResponse;
import com.kiosko.server.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class ProductListener {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ProductService productService;

    @RabbitListener(queuesToDeclare = @Queue(name = "product.create", durable = "true"))
    public String createProduct(String rec) {

        ProductDTO productDTO = productService.store(objectMapper.readValue(rec, ProductDTO.class));
        return objectMapper.writeValueAsString(productDTO);
    }

    @RabbitListener(queuesToDeclare = @Queue(name = "product.search", durable = "true"))
    public String searchProducts(int pageNum) {
        ProductPageResponse resp = productService.getProducts(pageNum);

        return objectMapper.writeValueAsString(resp);
    }

}
