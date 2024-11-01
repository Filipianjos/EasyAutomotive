package com.EasyAutomotive.controllers;

import com.EasyAutomotive.domain.models.Car;
import com.EasyAutomotive.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("{clientId}")
    public ResponseEntity<List<Car>> getCarByClient(@PathVariable Integer clientId){
        List<Car> cars = this.carService.getAllCarByClient(clientId);

        if (cars.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cars);
    }
}
