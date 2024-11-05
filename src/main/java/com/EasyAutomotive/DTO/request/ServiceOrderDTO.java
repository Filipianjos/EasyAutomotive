package com.EasyAutomotive.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ServiceOrderDTO{
    private String clientName;
    private String clientLastName;
    private String clientCpfCnpj;
    private String clientEmail;
    private String clientPhone;
    private String carModel;
    private String carBrand;
    private int carModelYear;

    public Integer carId;
    public Integer clientId;
    public Integer technicianId;
    public String details;

    public ServiceOrderDTO(Integer carId, Integer clientId, Integer technicianId, String details) {
        this.carId = carId;
        this.clientId = clientId;
        this.technicianId = technicianId;
        this.details = details;
    }

    public ServiceOrderDTO(){

    }

    public ServiceOrderDTO(
            String clientName,
            String clientLastname,
            String clientCpfCnpj,
            String clientEmail,
            String clientPhone,
            String carModel,
            String carBrand,
            int carModelYear,
            Integer serviceOrderTechnicianId,
            String details
    ){
        this.clientName = clientName;
        this.clientLastName = clientLastname;
        this.clientCpfCnpj = clientCpfCnpj;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carModelYear = carModelYear;
        this.technicianId = serviceOrderTechnicianId;
        this.details = details;
    }

}
