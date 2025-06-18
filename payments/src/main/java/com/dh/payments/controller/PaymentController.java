package com.dh.payments.controller;

import com.dh.payments.model.Payment;
import com.dh.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private PaymentService paymentService;
    Logger log = LoggerFactory.getLogger(PaymentController.class);

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public Payment getPayment(String id) {
        log.info("Intentando obtener el pago con id: " + id);
        return new Payment(id, 400.0f, "id 1", "id 2");
    }

    @PostMapping()
    public void createPayment(@RequestBody Payment payment) {
        paymentService.createPayment(payment);

    }
}
