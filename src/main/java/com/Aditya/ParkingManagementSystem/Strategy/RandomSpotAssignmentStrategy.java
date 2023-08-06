package com.Aditya.ParkingManagementSystem.Strategy;

import com.Aditya.ParkingManagementSystem.exceptions.NoParkingLotFoundException;
import com.Aditya.ParkingManagementSystem.models.*;
import com.Aditya.ParkingManagementSystem.services.ParkingLotService;
import com.Aditya.ParkingManagementSystem.services.ParkingSpotService;

import java.util.List;
import java.util.Map;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    ParkingSpotService parkingSpotService;
    ParkingLotService parkingLotService;
    public RandomSpotAssignmentStrategy(ParkingSpotService parkingSpotService, ParkingLotService parkingLotService)
    {
        this.parkingSpotService = parkingSpotService;
        this.parkingLotService = parkingLotService;
    }

    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Long gateId) throws NoParkingLotFoundException {
        ParkingLot parkingLot = parkingLotService.getParkingLotById(gateId);
        if(parkingLot==null)
            throw new NoParkingLotFoundException("No Parking Lot Found ");

        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpotsByLot(parkingLot);

        for(ParkingSpot parkingSpot : parkingSpots)
        {
            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
               parkingSpot.getVehicleTypeList().contains(vehicleType))
            {
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
                return parkingSpot;
            }
        }
        return null;
    }

}
