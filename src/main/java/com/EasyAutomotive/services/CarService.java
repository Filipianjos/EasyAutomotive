package com.EasyAutomotive.services;


import com.EasyAutomotive.domain.models.Car;
import com.EasyAutomotive.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    /** Método para regtistro de um novo carro **/
    public Car registerCar(Car newCar){
        this.carRepository.save(newCar);

        return newCar;
    }

    public List<Car> getAllCarByClient(Integer idClient){
        return  this.carRepository.findByClientId(idClient);
    }

    public Car getCarById(Integer id){
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente Não encontrado"));

    }
}
