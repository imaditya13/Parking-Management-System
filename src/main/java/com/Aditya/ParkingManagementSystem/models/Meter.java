package com.Aditya.ParkingManagementSystem.models;

import java.sql.Time;

public class Meter extends BaseEntity{

    private Integer price;
    private Time startTime;
    private Time endTime;

    public Meter(Long uuid) {
        super(uuid);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
