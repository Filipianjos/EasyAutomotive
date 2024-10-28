package com.EasyAutomotive.services;

import com.EasyAutomotive.DTO.request.MechanicDTO;
import com.EasyAutomotive.domain.models.Mechanic;
import com.EasyAutomotive.repositories.MechanicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    public MechanicDTO registerTechnician(MechanicDTO mechanicDTO){
        Mechanic newTechnician = new Mechanic();
        newTechnician.setTechnician(mechanicDTO.technician());

        this.mechanicRepository.save(newTechnician);
        return new MechanicDTO(newTechnician.getTechnician());
    }
}
