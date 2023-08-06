package com.Aditya.ParkingManagementSystem.models;

public class Operator extends BaseEntity {

    private String name;
    private Gate gate;

    public Operator(Long uuid, String name) {

        super(uuid);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
