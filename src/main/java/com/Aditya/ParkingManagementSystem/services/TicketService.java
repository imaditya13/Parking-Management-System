package com.Aditya.ParkingManagementSystem.services;

import com.Aditya.ParkingManagementSystem.Strategy.SpotAssignmentStrategy.SpotAssignmentStrategy;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketResponceDto;
import com.Aditya.ParkingManagementSystem.exceptions.EnterExitGateIdException;
import com.Aditya.ParkingManagementSystem.exceptions.NoGateIdFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoParkingLotFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoParkingSpotException;
import com.Aditya.ParkingManagementSystem.models.*;
import com.Aditya.ParkingManagementSystem.repositories.TicketRepository;

public class TicketService {
    VehicleService vehicleService;
    TicketRepository ticketRepository;
    GateService gateService;
    SpotAssignmentStrategy spotAssignmentStrategy;
    ParkingSpotService parkingSpotService;
    public TicketService(VehicleService vehicleService, GateService gateService,ParkingSpotService parkingSpotService,
                         SpotAssignmentStrategy spotAssignmentStrategy, TicketRepository ticketRepository)
    {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
        this.parkingSpotService = parkingSpotService;
    }
    public Ticket generateTicket(Long vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotException, NoGateIdFoundException, NoParkingLotFoundException, EnterExitGateIdException {


        Vehicle vehicle = vehicleService.gateVehicleByVehicleNumber(vehicleNumber);
        if(vehicle == null)
        {
             vehicle = vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }


        Gate gate = gateService.getGateByGateId(gateId);
        if(gate==null)
            throw new NoGateIdFoundException("No Gate Id Found");
        if(gate.getGateType().equals(GateType.Exit))
            throw new EnterExitGateIdException("This gate is not available for entry go through another gate");

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignParkingSpot(vehicle.getVehicleType(), gate.getId());

        if(parkingSpot==null)
            throw new NoParkingSpotException("No ParkingSpot Found");
        parkingSpotService.setParkingSpotStatusOccupied(parkingSpot);

         return ticketRepository.createTicket(vehicle,gate,parkingSpot);

    }

    public Ticket getTicketByVehicleNumber(Long vehicleNumber)
    {
        return ticketRepository.getTicketByVehicleNumber(vehicleNumber);
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
        System.out.println("Gate Type : "+ticket.getGate().getGateType());
    }
}
