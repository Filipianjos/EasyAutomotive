package com.EasyAutomotive.controllers;

import com.EasyAutomotive.DTO.request.MechanicDTO;
import com.EasyAutomotive.services.MechanicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mecanico")
@RequiredArgsConstructor
public class MechanicController {
    private final MechanicService mechanicService;

    @PostMapping
    public ResponseEntity<MechanicDTO> CreateMechanic(@RequestBody MechanicDTO body){
        MechanicDTO registerMechanic = this.mechanicService.registerTechnician(body);

        return ResponseEntity.ok(registerMechanic);
    }
}
