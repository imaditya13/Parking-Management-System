package com.Aditya.ParkingManagementSystem.factories;

import com.Aditya.ParkingManagementSystem.Strategy.PricingStrategy.FirstPricingStrategy;
import com.Aditya.ParkingManagementSystem.Strategy.PricingStrategy.PriceStrategy;

public class CalculatePricingStrategyFactory {
    public static PriceStrategy getPricingStrategy()
    {
        return new FirstPricingStrategy();
       // return  null;
    }
}
