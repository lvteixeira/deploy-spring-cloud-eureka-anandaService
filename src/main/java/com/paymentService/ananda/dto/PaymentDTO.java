package com.paymentService.ananda.dto;

import java.util.UUID;

public class PaymentDTO {
    private String id;
    private String ownerId;
    private String amount;

    public PaymentDTO() {}

    public PaymentDTO(String ownerId, String amount) {
        this.id = UUID.randomUUID().toString();
        this.ownerId = ownerId;
        this.amount = amount;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getOwnerId() { return ownerId; }

    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }
}
