package com.Aditya.ParkingManagementSystem.services;

import com.Aditya.ParkingManagementSystem.models.Gate;
import com.Aditya.ParkingManagementSystem.repositories.GateRepository;

public class GateService {
    GateRepository gateRepository;
    public GateService(GateRepository gateRepository)
    {
        this.gateRepository = gateRepository;
    }
    public Gate getGateByGateId(Long gateId)
    {
        return  gateRepository.getGateByGateId(gateId);
    }
}
