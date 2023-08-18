package com.Aditya.ParkingManagementSystem.repositories;

import com.Aditya.ParkingManagementSystem.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingSpotRepository {

    public List<ParkingSpot> getParkingSpotForParkingLot(ParkingLot parkingLot)
    {
        List<ParkingSpot>parkingSpotList = new ArrayList<>();

        for(Floor floor : parkingLot.getFloorList())
        {
            for(ParkingSpot parkingSpot : floor.getParkingSpotList())
            {
                parkingSpotList.add(parkingSpot);
            }
        }

        return parkingSpotList;
    }
    public void setParkingSpotStatusOccupied(ParkingSpot parkingSpot)
    {
       parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
    }
    public void setParkingSpotStatusAvailable(ParkingSpot parkingSpot)
    {
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
    }
}
