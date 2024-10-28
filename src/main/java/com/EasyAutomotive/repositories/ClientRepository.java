package com.EasyAutomotive.repositories;

import com.EasyAutomotive.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
