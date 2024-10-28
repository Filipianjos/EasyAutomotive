package com.EasyAutomotive.repositories;

import com.EasyAutomotive.domain.models.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, UUID> {
}
