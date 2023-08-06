package com.Aditya.ParkingManagementSystem.models;

public class BaseEntity {
     Long id;
    public BaseEntity(){}
    public BaseEntity(Long uuid) {
        this.id = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
