package com.EasyAutomotive.DTO.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ServiceOrderResponseDTO(
        UUID id,
        String client,
        String cpf,
        String car,
        int year,
        LocalDateTime openDate,
        LocalDateTime closeDate,
        String details
) {
}
