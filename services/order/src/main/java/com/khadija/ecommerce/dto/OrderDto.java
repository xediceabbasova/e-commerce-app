package com.khadija.ecommerce.dto;

import com.khadija.ecommerce.model.PaymentMethod;

import java.math.BigDecimal;

public record OrderDto(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
