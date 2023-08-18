package com.Aditya.ParkingManagementSystem.Strategy.SpotAssignmentStrategy;

import com.Aditya.ParkingManagementSystem.exceptions.NoParkingLotFoundException;
import com.Aditya.ParkingManagementSystem.models.*;

public interface SpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(VehicleType vehicleType, Long gateId) throws NoParkingLotFoundException;

}
