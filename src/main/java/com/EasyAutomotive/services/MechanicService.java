package com.EasyAutomotive.services;

import com.EasyAutomotive.DTO.request.MechanicDTO;
import com.EasyAutomotive.DTO.response.MechanicResponseIdDTO;
import com.EasyAutomotive.domain.models.Mechanic;
import com.EasyAutomotive.repositories.MechanicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;
    private final ApplicationEventPublisher eventPublisher;

    public MechanicDTO registerTechnician(MechanicDTO mechanicDTO){
        Mechanic newTechnician = new Mechanic();
        newTechnician.setTechnician(mechanicDTO.technician());

        this.mechanicRepository.save(newTechnician);
        eventPublisher.publishEvent(new MechanicResponseIdDTO(newTechnician.getId()));
        return new MechanicDTO(newTechnician.getId(), newTechnician.getTechnician());
    }

    public Mechanic getMechanicById(Integer id){
        return mechanicRepository.findById(id).orElseThrow(() -> new RuntimeException("Mecanico não encotrado"));
    }
}
