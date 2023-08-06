package com.Aditya.ParkingManagementSystem.models;

public class Vehicle extends BaseEntity{
    private VehicleType vehicleType;
    private Long number;

    public Vehicle(VehicleType vehicleType, Long number, long uuid) {
        super(uuid);
        this.number = number;
        this. vehicleType = vehicleType;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
