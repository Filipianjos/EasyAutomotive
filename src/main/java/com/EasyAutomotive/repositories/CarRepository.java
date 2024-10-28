package com.EasyAutomotive.repositories;

import com.EasyAutomotive.domain.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
