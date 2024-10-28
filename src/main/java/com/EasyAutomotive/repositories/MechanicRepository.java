package com.EasyAutomotive.repositories;

import com.EasyAutomotive.domain.models.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {
}
