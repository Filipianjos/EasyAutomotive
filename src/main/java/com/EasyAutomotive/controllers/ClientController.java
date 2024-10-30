package com.EasyAutomotive.controllers;

import com.EasyAutomotive.DTO.request.CarDTO;
import com.EasyAutomotive.DTO.request.ClientDTO;
import com.EasyAutomotive.DTO.response.CarResponseIdDTO;
import com.EasyAutomotive.DTO.response.ClientResponseDTO;
import com.EasyAutomotive.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    /**Rota para cadastrar um cliente**/
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO body){
        ClientDTO newClient = this.clientService.registerClient(body);

        return ResponseEntity.ok(body);
    }

    /**Rota para consultar o cliente por ID**/
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClient(@PathVariable Integer id){
        ClientResponseDTO client = this.clientService.getClient(id);

        return ResponseEntity.ok(client);
    }

    /** Rota para cadastrar um veículo **/
    @PostMapping("/{clientId}/carro")
    public ResponseEntity<CarResponseIdDTO> createCar(@PathVariable Integer clientId, @RequestBody CarDTO body){
        CarResponseIdDTO car = clientService.crateCar(clientId, body);

        return ResponseEntity.ok(car);
    }
}
