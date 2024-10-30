package com.EasyAutomotive.DTO.request;

import com.EasyAutomotive.domain.models.Client;

public record CarDTO(
        String model,
        String brand,
        int modelYear,
        Integer clientID
) {
}
