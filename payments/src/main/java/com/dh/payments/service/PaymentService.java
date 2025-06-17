package com.dh.payments.service;

import com.dh.payments.client.PaymentClient;
import com.dh.payments.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PublishNotification publishNotification;
    private PaymentClient paymentClient;

    public PaymentService(PublishNotification publishNotification, PaymentClient paymentClient) {
        this.publishNotification = publishNotification;
        this.paymentClient = paymentClient;
    }

    public void createPayment(Payment payment){

        paymentClient.createPayment(payment);
        publishNotification.sendMessageToTopic(payment.getClientId());
    }
}
