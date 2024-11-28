package com.EasyAutomotive.services;

import com.EasyAutomotive.DTO.request.CarIdDTO;
import com.EasyAutomotive.DTO.request.ServiceOrderDTO;
import com.EasyAutomotive.DTO.response.ServiceOrderResponseDTO;
import com.EasyAutomotive.domain.events.CreatedCarEvent;
import com.EasyAutomotive.domain.events.CreatedClientEvent;
import com.EasyAutomotive.domain.events.CreatedMechanicEvent;
import com.EasyAutomotive.domain.models.Car;
import com.EasyAutomotive.domain.models.Client;
import com.EasyAutomotive.domain.models.Mechanic;
import com.EasyAutomotive.domain.models.ServiceOrder;
import com.EasyAutomotive.repositories.CarRepository;
import com.EasyAutomotive.repositories.ClientRepository;
import com.EasyAutomotive.repositories.MechanicRepository;
import com.EasyAutomotive.repositories.ServiceOrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.Period.between;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {
    private final ServiceOrderRepository serviceOrderRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    // Método para criar uma lrdem de Servico

    @Transactional
    public  ServiceOrderDTO createdOrderService(ServiceOrderDTO serviceOrderDTO){
        Client client = new Client();
        client.setName(serviceOrderDTO.getClientName());
        client.setLastname(serviceOrderDTO.getClientLastName());
        client.setCpfCnpj(serviceOrderDTO.getClientCpfCnpj());
        client.setEmail(serviceOrderDTO.getClientEmail());
        client.setPhone(serviceOrderDTO.getClientPhone());
        client = clientRepository.save(client);

        CarIdDTO carIdDTO;
        Car car = new Car();
        car.setModel(serviceOrderDTO.getCarModel());
        car.setBrand(serviceOrderDTO.getCarBrand());
        car.setModelYear(serviceOrderDTO.getCarModelYear());
        car.setClient(client);
        car = carRepository.save(car);

        ServiceOrder newSO = new ServiceOrder();
        newSO.setUuid(UUID.randomUUID());
        newSO.setClient(client);
        newSO.setCar(car);
        newSO.setTechnician(searchMechanic(serviceOrderDTO.technicianId));
        newSO.setDateOpen(LocalDateTime.now());
        newSO.setDetails(serviceOrderDTO.details);
        this.serviceOrderRepository.save(newSO);

        CreatedClientEvent clientEvent = new CreatedClientEvent(this, client.getId());

        applicationEventPublisher.publishEvent(clientEvent);

        return serviceOrderDTO;
    }

        /** Método para exibir os dados da ordem de seviço**/
    public ServiceOrderResponseDTO showServiceOrder(ServiceOrder serviceOrder, Client client ,Car car){
        return new  ServiceOrderResponseDTO(
                serviceOrder.getUuid(),
                joinNameLastname(client.getId()),
                serviceOrder.getClient().getCpfCnpj(),
                joinCarModel(car.getId()),
                serviceOrder.getCar().getModelYear(),
                serviceOrder.getDateOpen(),
                serviceOrder.getDateClose(),
                serviceOrder.getDetails()
        );

    }

    public List<ServiceOrderResponseDTO> getAllServiceOrder(){
        List<ServiceOrder> serviceOrders = serviceOrderRepository.findAll();
        return convertDTO(serviceOrders);
    }

    public List<ServiceOrderResponseDTO> getServiceOrderByName(String name, String lastname){
        List<ServiceOrder> serviceOrders = serviceOrderRepository.findByClientNameAndClientLastname(name, lastname);
        return convertDTO(serviceOrders);
    }

    public List<ServiceOrderResponseDTO> getServiceOrderByCpfCnpj(String cpfCnpj){
        List<ServiceOrder> serviceOrders = serviceOrderRepository.findByClientCpfCnpj(cpfCnpj);

        return convertDTO(serviceOrders);
    }

    /** Método para consultar um mecânico e inseri-lo na O.S **/
    private Mechanic searchMechanic(Integer id){
        return mechanicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mecânico não localizado"));
    }

    /** Método para concatenar o nome do usuário **/
    private String joinNameLastname(Integer id){
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não localizado"));

        return client.getName() + " " + client.getLastname();
    }

    /** Método para concatenar o modelo carro com a marca **/
    private String joinCarModel(Integer id){
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao localizar veículo"));

        return car.getModel() + " " + car.getBrand();
    }

    /** Método para converter a O.S em um DTO **/
    private List<ServiceOrderResponseDTO> convertDTO(List<ServiceOrder>serviceOrders){
        return serviceOrders.stream()
                .map(serviceOrder -> {
                    Car car = serviceOrder.getCar();
                    Client client = serviceOrder.getClient();
                    return new ServiceOrderResponseDTO(
                            serviceOrder.getUuid(),
                            joinNameLastname(client.getId()),
                            serviceOrder.getClient().getCpfCnpj(),
                            joinCarModel(car.getId()),
                            serviceOrder.getCar().getModelYear(),
                            serviceOrder.getDateOpen(),
                            serviceOrder.getDateClose(),
                            serviceOrder.getDetails()
                    );
        }).toList();
    }


}
