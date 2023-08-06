package com.Aditya.ParkingManagementSystem.dto;

import com.Aditya.ParkingManagementSystem.models.Vehicle;
import com.Aditya.ParkingManagementSystem.models.VehicleType;

public class GenerateTicketRequestDto {
    private Long vehicleNumber;
    private VehicleType vehicleType;
    private Long gateId;

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
}
