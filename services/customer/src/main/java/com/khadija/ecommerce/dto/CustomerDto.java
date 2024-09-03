package com.khadija.ecommerce.dto;

import com.khadija.ecommerce.model.Address;

public record CustomerDto(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
