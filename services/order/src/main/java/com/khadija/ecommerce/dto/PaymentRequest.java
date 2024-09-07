package com.khadija.ecommerce.dto;

import com.khadija.ecommerce.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerDto customer
) {
}
