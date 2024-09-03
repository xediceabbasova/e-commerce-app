package com.khadija.ecommerce.dto;

import java.math.BigDecimal;

public record ProductPurchaseDto(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
