package com.Aditya.ParkingManagementSystem.Strategy.PricingStrategy;

public class FirstPricingStrategy implements PriceStrategy{
    @Override
    public Integer calculatePrice(Long entryTime, Long exitTime) {
        return 500;
    }
}
