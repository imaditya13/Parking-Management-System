package com.Aditya.ParkingManagementSystem.Strategy.PricingStrategy;

public interface PriceStrategy {
    Integer calculatePrice(Long entryTime, Long exitTime);

}
