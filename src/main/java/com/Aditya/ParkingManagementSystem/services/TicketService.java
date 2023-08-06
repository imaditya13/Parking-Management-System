package com.Aditya.ParkingManagementSystem.services;

import com.Aditya.ParkingManagementSystem.Strategy.SpotAssignmentStrategy;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketResponceDto;
import com.Aditya.ParkingManagementSystem.exceptions.NoGateIdFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoParkingLotFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoParkingSpotException;
import com.Aditya.ParkingManagementSystem.models.*;

public class TicketService {
    VehicleService vehicleService;
    GateService gateService;
    SpotAssignmentStrategy spotAssignmentStrategy;
    public TicketService(VehicleService vehicleService, GateService gateService,SpotAssignmentStrategy spotAssignmentStrategy)
    {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }
    public Ticket generateTicket(Long vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotException, NoGateIdFoundException, NoParkingLotFoundException {
        Ticket ticket = new Ticket(System.currentTimeMillis());

        Vehicle vehicle = vehicleService.gateVehicleByVehicleNumber(vehicleNumber);
        if(vehicle == null)
        {
             vehicle = vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }


        Gate gate = gateService.getGateByGateId(gateId);
        if(gate==null)
            throw new NoGateIdFoundException("No Gate Id Found");


        ParkingSpot parkingSpot = spotAssignmentStrategy.assignParkingSpot(vehicle.getVehicleType(), gate.getId());


        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(System.currentTimeMillis());

        if(parkingSpot==null)
            throw new NoParkingSpotException("No ParkingSpot Found");
        ticket.setParkingSpot(parkingSpot);

        return ticket;
    }
    public void displayMyTicket(GenerateTicketResponceDto responceDto)
    {
        Ticket ticket = responceDto.getTicket();
        if(responceDto.getResponseStatus().equals(ResponseStatus.SUCCESS))
        {
            System.out.println("your ticket generated successfully");
        }

      //  System.out.println("Welcome to : "+parkingLot.getName());
        System.out.println("Floor No : "+ ticket.getParkingSpot().getFloorNo());
        System.out.println("Parking spot No : "+ticket.getParkingSpot().getNumber());
        System.out.println("Vehicle No : "+ticket.getVehicle().getNumber());
        System.out.println("Supported vehicles list for this Parking spot are : "+ticket.getParkingSpot().getVehicleTypeList());
        System.out.println("Operator Name : "+ticket.getOperator().getName());
        System.out.println("Gate No : "+ticket.getGate().getNumber());
        System.out.println("Entry Time : "+ticket.getEntryTime());
    }
}
