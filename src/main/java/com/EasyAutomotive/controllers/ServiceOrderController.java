package com.EasyAutomotive.controllers;

import com.EasyAutomotive.DTO.request.ServiceOrderDTO;
import com.EasyAutomotive.services.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/O-S")
@RequiredArgsConstructor
public class ServiceOrderController {
    private final ServiceOrderService serviceOrderService;

    @PostMapping
    public ResponseEntity<String> createServiceOrder(@RequestBody ServiceOrderDTO serviceOrderDTO){
        ServiceOrderDTO newSO = serviceOrderService.createdOrderService(serviceOrderDTO);

        return ResponseEntity.ok("Ordem de Serviço criada com sucesso!");
    }

}
