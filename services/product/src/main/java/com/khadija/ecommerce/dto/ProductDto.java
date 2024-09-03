package com.khadija.ecommerce.dto;

import java.math.BigDecimal;

public record ProductDto(
        Integer id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
