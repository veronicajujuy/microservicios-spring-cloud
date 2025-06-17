package com.dh.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    Logger log = LoggerFactory.getLogger(NotificationConsumer.class);

    @RabbitListener(queues = "send-notification")
    public void consumer(String message) {
        log.info("Mensaje recibido: " + message);
        // Aquí puedes agregar la lógica para procesar el mensaje recibido
        // Por ejemplo, enviar una notificación al usuario o guardar en la base de datos
    }
}
