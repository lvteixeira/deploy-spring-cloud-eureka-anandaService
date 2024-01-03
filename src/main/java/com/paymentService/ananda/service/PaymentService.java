package com.paymentService.ananda.service;

import com.paymentService.ananda.dto.PaymentDTO;
import com.paymentService.ananda.model.Payment;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    ModelMapper modelMapper;

    private List<Payment> payments = new ArrayList<>();

    public PaymentService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        TypeMap<PaymentDTO, Payment> typeMap = this.modelMapper.createTypeMap(PaymentDTO.class, Payment.class);

        typeMap.addMappings(mapper -> mapper.skip(Payment::setId));
    }

    public Payment convertDTOToEntity(PaymentDTO dto) {
        return modelMapper.map(dto, Payment.class);
    }

    public PaymentDTO convertEntityToDTO(Payment entity) {
        return modelMapper.map(entity, PaymentDTO.class);
    }

    public void create(Payment payment) {
        payments.add(payment);
        this.publish("payment created, id: "+payment.getId());
    }

    public void publish(String message) {
        //simulate message enqueue on payment channel
        System.out.println(message);
    }
}