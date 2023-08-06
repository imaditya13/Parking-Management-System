package com.Aditya.ParkingManagementSystem.models;

import java.sql.Date;

public class Ticket extends BaseEntity{
    private Gate gate;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private Long entryTime;
    private Operator operator;
    private ParkingLot parkingLot;
   public Ticket(){

   }
    public Ticket(Long uuid) {
        super(uuid);
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Long entryTime) {
        this.entryTime = entryTime;
    }
}
