package com.Aditya.ParkingManagementSystem.models;

public class EVParkingSpot extends ParkingSpot{
    private Meter meter;

    public EVParkingSpot(Long uuid) {
        super(uuid);
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

}
