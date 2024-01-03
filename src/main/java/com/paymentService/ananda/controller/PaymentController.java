package com.paymentService.ananda.controller;

import com.paymentService.ananda.dto.PaymentDTO;
import com.paymentService.ananda.model.Payment;
import com.paymentService.ananda.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Mono<?> processPayment(@RequestBody PaymentDTO payload) {
        return Mono.fromSupplier(() -> {
           Payment payment = paymentService.convertDTOToEntity(payload);
           try {
               paymentService.create(payment);
               PaymentDTO createdPayment = paymentService.convertEntityToDTO(payment);
               return ResponseEntity
                       .status(HttpStatus.CREATED)
                       .body(createdPayment);
           } catch (RuntimeException e) {
               return ResponseEntity
                       .status(HttpStatus.INTERNAL_SERVER_ERROR)
                       .body("Payment creation failed. "+e.getMessage());
           }
        });
    }
}
