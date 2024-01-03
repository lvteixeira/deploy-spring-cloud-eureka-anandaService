package com.paymentService.ananda.model;

import com.paymentService.ananda.service.PaymentService;

import java.util.UUID;

public class Payment {
    private String id;
    private String ownerId;
    private String amount;

    public Payment() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getOwnerId() { return ownerId; }

    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }
}
