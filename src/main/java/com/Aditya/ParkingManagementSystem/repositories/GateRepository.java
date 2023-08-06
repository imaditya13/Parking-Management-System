package com.Aditya.ParkingManagementSystem.repositories;

import com.Aditya.ParkingManagementSystem.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    Map<Long, Gate>gateMap = new HashMap<>();
    public GateRepository(Map<Long,Gate>gateMap)
    {
        this.gateMap = gateMap;
    }
    public Gate getGateByGateId(Long gateId)
    {
        if(gateMap.containsKey(gateId)) {
            return gateMap.get(gateId);
        }
        return null;
    }
}
