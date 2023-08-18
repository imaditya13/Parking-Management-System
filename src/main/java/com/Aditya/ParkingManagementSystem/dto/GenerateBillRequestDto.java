package com.Aditya.ParkingManagementSystem.dto;

public class GenerateBillRequestDto {
    private Long vehicleNumber;
    private  Long gateId;

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

}
