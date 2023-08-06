package com.Aditya.ParkingManagementSystem.services;

import com.Aditya.ParkingManagementSystem.models.Vehicle;
import com.Aditya.ParkingManagementSystem.models.VehicleType;
import com.Aditya.ParkingManagementSystem.repositories.VehicleRepository;

import java.util.Scanner;
import java.util.UUID;

public class VehicleService {
    VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
    }
    public Vehicle gateVehicleByVehicleNumber(Long vehicleNumber)
    {
       return vehicleRepository.gateVehicleByVehicleNumber(vehicleNumber);
    }
    public Vehicle registerVehicle(Long vehicleNumber, VehicleType vehicleType)
    {

        return vehicleRepository.reisterVehicle(vehicleNumber, vehicleType);
    }
}
