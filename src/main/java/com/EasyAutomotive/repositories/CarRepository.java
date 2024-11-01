package com.EasyAutomotive.repositories;

import com.EasyAutomotive.domain.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByClientId(Integer idClient);
}
