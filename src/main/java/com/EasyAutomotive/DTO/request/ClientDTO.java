package com.EasyAutomotive.DTO.request;

public record ClientDTO(
        String name,
        String lastname,
        String cpfCnpj,
        String email,
        String phone
) {

}
