package com.EasyAutomotive.DTO.request;

public record CarIdDTO(
        Integer id,

        String model,

        String brand,

        int modelYear,

        Integer clientID) {
}
