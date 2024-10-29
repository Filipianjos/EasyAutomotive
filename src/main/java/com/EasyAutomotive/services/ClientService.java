package com.EasyAutomotive.services;

import com.EasyAutomotive.DTO.request.ClientDTO;
import com.EasyAutomotive.DTO.response.ClientResponseDTO;
import com.EasyAutomotive.domain.models.Client;
import com.EasyAutomotive.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    /** Método para registrar cliente **/
    public ClientDTO registerClient(ClientDTO clientDTO) {
        Client newClient = new Client();
            newClient.setName(clientDTO.name());
            newClient.setLastname(clientDTO.lastname());
            newClient.setCpfCnpj(clientDTO.cpfCnpj());
            newClient.setEmail(clientDTO.email());
            newClient.setPhone(clientDTO.phone());

            this.clientRepository.save(newClient);

        return new ClientDTO(newClient.getName(), newClient.getLastname(), newClient.getCpfCnpj(), newClient.getEmail(), newClient.getPhone());
    }

    /** Método para consultar o cliente pelo ID**/
    public ClientResponseDTO getClient(Integer id){
        Client client = this.getClientById(id);

        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getLastname(),
                client.getCpfCnpj(),
                client.getEmail(),
                client.getPhone());
    }

    /** Método que extrai o cliente **/
    private Client getClientById(Integer id){
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente Não encontrado"));
    }
}