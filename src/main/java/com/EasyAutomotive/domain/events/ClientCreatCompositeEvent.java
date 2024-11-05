package com.EasyAutomotive.domain.events;

public record ClientCreatCompositeEvent(
      CreatedClientEvent clientEvent,
      CreatedCarEvent carEvent,
      CreatedMechanicEvent mechanicEvent
) {
    public ClientCreatCompositeEvent(CreatedClientEvent clientEvent, CreatedCarEvent carEvent, CreatedMechanicEvent mechanicEvent){
        this.clientEvent = clientEvent;
        this.carEvent = carEvent;
        this.mechanicEvent = mechanicEvent;
    }
}
