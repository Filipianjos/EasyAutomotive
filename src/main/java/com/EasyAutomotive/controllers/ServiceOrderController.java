package com.EasyAutomotive.controllers;

import com.EasyAutomotive.DTO.request.ServiceOrderDTO;
import com.EasyAutomotive.DTO.response.ServiceOrderResponseDTO;
import com.EasyAutomotive.services.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<ServiceOrderResponseDTO> getServiceOrders(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String cpfCnpj) {
        if (name != null && lastname != null){
            return serviceOrderService.getServiceOrderByName(name, lastname);
        } else if (cpfCnpj != null) {
            return serviceOrderService.getServiceOrderByCpfCnpj(cpfCnpj);
        } else {
            return serviceOrderService.getAllServiceOrder();
        }
    }

}
