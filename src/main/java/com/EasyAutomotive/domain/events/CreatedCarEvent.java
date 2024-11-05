package com.EasyAutomotive.domain.events;

import com.EasyAutomotive.DTO.request.CarIdDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreatedCarEvent extends ApplicationEvent {
    private final CarIdDTO carIdDTO;

    public CreatedCarEvent(Object source, CarIdDTO carId){
        super(source);
        this.carIdDTO = carId;
    }
}
