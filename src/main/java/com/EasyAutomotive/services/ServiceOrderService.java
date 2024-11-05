package com.EasyAutomotive.services;

import com.EasyAutomotive.DTO.request.CarIdDTO;
import com.EasyAutomotive.DTO.request.ServiceOrderDTO;
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
import java.util.UUID;

import static java.time.Period.between;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {
    private final ServiceOrderRepository serviceOrderRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

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

    private Mechanic searchMechanic(Integer id){
        return mechanicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mecânico não localizado"));
    }

}
