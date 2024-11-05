package com.EasyAutomotive.domain.events;

import com.EasyAutomotive.DTO.request.CarIdDTO;
import com.EasyAutomotive.DTO.request.ServiceOrderDTO;
import com.EasyAutomotive.domain.models.Car;
import com.EasyAutomotive.domain.models.Client;
import com.EasyAutomotive.domain.models.Mechanic;
import com.EasyAutomotive.repositories.CarRepository;
import com.EasyAutomotive.repositories.ClientRepository;
import com.EasyAutomotive.repositories.MechanicRepository;
import com.EasyAutomotive.services.ServiceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatedClientListener {
    private final ServiceOrderService serviceOrderService;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;
    @EventListener
    public void onClientCreated(ClientCreatCompositeEvent compositeEvent){
        Integer clientId = compositeEvent.clientEvent().getClientId();

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Falha ao localizar cliente"));

        CarIdDTO carId = compositeEvent.carEvent().getCarIdDTO();
        Car newCar = new Car();
        newCar.setModel(carId.model());
        newCar.setBrand(carId.brand());
        newCar.setModelYear(carId.modelYear());
        newCar.setClient(client);
        carRepository.save(newCar);

        Integer technicianId = compositeEvent.mechanicEvent().getTechnicianId();
        Mechanic mechanic = mechanicRepository.findById(technicianId)
                .orElseThrow(() -> new RuntimeException("Mecânico não localizado"));

        ServiceOrderDTO newServiceOrderDTO = new ServiceOrderDTO();
        newServiceOrderDTO.clientId = client.getId();
        newServiceOrderDTO.carId = newCar.getId();
        newServiceOrderDTO.technicianId = mechanic.getId();
        newServiceOrderDTO.details = "";

        serviceOrderService.createdOrderService(newServiceOrderDTO);
    }

}
