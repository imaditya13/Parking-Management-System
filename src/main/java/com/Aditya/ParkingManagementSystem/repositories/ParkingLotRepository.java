package com.Aditya.ParkingManagementSystem.repositories;

import com.Aditya.ParkingManagementSystem.models.Gate;
import com.Aditya.ParkingManagementSystem.models.ParkingLot;
import com.Aditya.ParkingManagementSystem.models.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Long,ParkingLot> parkingLots = new HashMap<>();
    public ParkingLotRepository(Map<Long,ParkingLot>parkingLots)
    {
        this.parkingLots = parkingLots;
    }
    public ParkingLot getParkingLotById(Long gateId)
    {

        for(ParkingLot parkingLot : parkingLots.values())
        {
            for(Gate gate : parkingLot.getGateMap().values())
            {
                if(gate.getId().equals(gateId))
                {
                    return parkingLot;
                }
            }
        }
        return  null;//new ParkingLot("CITY MALL", System.currentTimeMillis());
    }
}
