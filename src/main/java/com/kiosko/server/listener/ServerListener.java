package com.kiosko.server.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
class ServerListener {
    @RabbitListener(queuesToDeclare = @Queue(name = "server.connection", durable = "true"))
    public String verificarConexión(String message) {
        return "pong";
    }

}
