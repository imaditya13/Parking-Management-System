package com.Aditya.ParkingManagementSystem.repositories;

import com.Aditya.ParkingManagementSystem.models.Gate;
import com.Aditya.ParkingManagementSystem.models.ParkingSpot;
import com.Aditya.ParkingManagementSystem.models.Ticket;
import com.Aditya.ParkingManagementSystem.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Long,Ticket>ticketMap = new HashMap<>();
    public TicketRepository(Map<Long,Ticket>ticketMap)
    {

        //this.ticketMap = ticketMap;
    }
    public Ticket createTicket(Vehicle vehicle, Gate gate, ParkingSpot parkingSpot)
    {
        Ticket ticket = new Ticket(System.currentTimeMillis());
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(System.currentTimeMillis());
        ticket.setParkingSpot(parkingSpot);

        ticketMap.put(vehicle.getNumber(),ticket);
        return ticket;
    }
    public Ticket getTicketByVehicleNumber(Long vehicleNumber)
    {
        if(ticketMap.containsKey(vehicleNumber))
        {
            return ticketMap.get(vehicleNumber);
        }
        return null;
    }
}
