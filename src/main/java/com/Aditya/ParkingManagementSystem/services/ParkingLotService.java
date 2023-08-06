package com.Aditya.ParkingManagementSystem.services;

import com.Aditya.ParkingManagementSystem.models.Gate;
import com.Aditya.ParkingManagementSystem.models.ParkingLot;
import com.Aditya.ParkingManagementSystem.repositories.ParkingLotRepository;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotService {
    ParkingLotRepository parkingLotRepository;
    public ParkingLotService(ParkingLotRepository parkingLotRepository)
    {
        this.parkingLotRepository = parkingLotRepository;
    }
    public ParkingLot getParkingLotById(Long gateId)
    {
       return parkingLotRepository.getParkingLotById(gateId);
    }
}
