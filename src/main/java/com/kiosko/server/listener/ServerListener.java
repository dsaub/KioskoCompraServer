package com.kiosko.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
class ServerListener {
    Logger logger = LoggerFactory.getLogger(ServerListener.class);
    @RabbitListener(queuesToDeclare = @Queue(name = "server.connection", durable = "true"))
    public String verificarConexión(String message) {
        logger.info("event=message,queue=server.connection");
        return "pong";
    }

}
