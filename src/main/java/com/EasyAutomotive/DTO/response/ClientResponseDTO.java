package com.EasyAutomotive.DTO.response;

import lombok.AllArgsConstructor;


public record ClientResponseDTO(
        Integer id,
        String name,
        String lastname,
        String cpfCnpj,
        String email,
        String phone
){

}
