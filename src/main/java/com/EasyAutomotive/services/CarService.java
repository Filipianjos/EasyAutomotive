package com.EasyAutomotive.services;


import com.EasyAutomotive.domain.models.Car;
import com.EasyAutomotive.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    /** Método para regtistro de um novo carro **/
    public Car registerCar(Car newCar){
        this.carRepository.save(newCar);

        return newCar;
    }

}
