package com.EasyAutomotive.repositories;

import com.EasyAutomotive.domain.models.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, UUID> {

    List<ServiceOrder> findByClientNameAndClientLastname(String name, String lastname);

    List<ServiceOrder> findByClientCpfCnpj(String cpfCnpj);
}
