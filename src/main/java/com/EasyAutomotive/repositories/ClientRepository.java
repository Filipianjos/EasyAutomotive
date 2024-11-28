package com.EasyAutomotive.repositories;

import com.EasyAutomotive.domain.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByNameAndLastname(String name, String lastname);

    List<Client> findByCpfCnpj(String cpfCnpj);
}
