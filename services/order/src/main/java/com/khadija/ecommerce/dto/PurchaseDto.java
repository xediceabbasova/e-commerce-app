package com.khadija.ecommerce.dto;

import java.math.BigDecimal;

public record PurchaseDto(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
