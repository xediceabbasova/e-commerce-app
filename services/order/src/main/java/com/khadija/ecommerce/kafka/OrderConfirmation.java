package com.khadija.ecommerce.kafka;

import com.khadija.ecommerce.dto.CustomerDto;
import com.khadija.ecommerce.dto.PurchaseDto;
import com.khadija.ecommerce.model.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerDto customer,
        List<PurchaseDto> products
) {
}
