package com.EasyAutomotive.domain.events;

import lombok.Getter;

@Getter
public class CreatedMechanicEvent {
    private final Integer technicianId;

    public CreatedMechanicEvent(Object source, Integer technicianId){
        super();
        this.technicianId = technicianId;
    }
}
