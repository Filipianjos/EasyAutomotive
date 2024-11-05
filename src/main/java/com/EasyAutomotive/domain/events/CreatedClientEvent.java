package com.EasyAutomotive.domain.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter

public class CreatedClientEvent extends ApplicationEvent {
    private final Integer clientId;

    /** Construtor de publicação de criação do cliente **/
    public CreatedClientEvent(Object source, Integer clientId){
        super(source);
        this.clientId = clientId;
    }

}
