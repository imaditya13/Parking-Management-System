package com.Aditya.ParkingManagementSystem.repositories;

import com.Aditya.ParkingManagementSystem.models.Vehicle;
import com.Aditya.ParkingManagementSystem.models.VehicleType;
import com.Aditya.ParkingManagementSystem.services.VehicleService;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    Map<Long, Vehicle>vehicleMap = new HashMap<>();

    public Vehicle gateVehicleByVehicleNumber (Long vehicleNumber)
    {

        if(vehicleMap.containsKey(vehicleNumber))
        {
            return vehicleMap.get(vehicleNumber);
        }
        return null;
    }
    public  Vehicle reisterVehicle(Long vehicleNumber, VehicleType vehicleType)
    {
       Vehicle vehicle = new Vehicle(vehicleType, vehicleNumber, System.currentTimeMillis());
       vehicleMap.put(vehicle.getNumber(),vehicle);
       return  vehicle;
    }
}
