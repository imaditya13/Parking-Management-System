package com.Aditya.ParkingManagementSystem.services;

import com.Aditya.ParkingManagementSystem.models.ParkingLot;
import com.Aditya.ParkingManagementSystem.models.ParkingSpot;
import com.Aditya.ParkingManagementSystem.models.ParkingSpotStatus;
import com.Aditya.ParkingManagementSystem.models.VehicleType;
import com.Aditya.ParkingManagementSystem.repositories.ParkingLotRepository;
import com.Aditya.ParkingManagementSystem.repositories.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingSpotService {
    ParkingSpotRepository parkingSpotRepository;
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository)
    {
        this.parkingSpotRepository = parkingSpotRepository;
    }
    public List<ParkingSpot> getParkingSpotsByLot(ParkingLot parkingLot) {

       return parkingSpotRepository.getParkingSpotForParkingLot(parkingLot);

    }
    public void setParkingSpotStatusOccupied(ParkingSpot parkingSpot)
    {
        parkingSpotRepository.setParkingSpotStatusOccupied(parkingSpot);
    }
    public void setParkingSpotStatusAvailable(ParkingSpot parkingSpot)
    {
        parkingSpotRepository.setParkingSpotStatusAvailable(parkingSpot);
    }
}
