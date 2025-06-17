package com.dh.payments.client;

import com.dh.payments.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentClient {
    public Boolean createPayment(Payment payment) {
        // Simula una llmada a un servicio externo para crear un pago
        return true;
    }
}
