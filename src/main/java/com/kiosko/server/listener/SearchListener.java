package com.kiosko.server.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
class SearchListener {

    @RabbitListener(queuesToDeclare = @Queue(name="product.search", durable = "true"))
    public String searchProduct(String rec) {
        return "on-demand"; //TODO: Create this function
    }
}
