package com.Aditya.ParkingManagementSystem.services;

import com.Aditya.ParkingManagementSystem.Strategy.PricingStrategy.PriceStrategy;
import com.Aditya.ParkingManagementSystem.dto.GenerateBillResponceDto;
import com.Aditya.ParkingManagementSystem.exceptions.EnterEntryGateIdException;
import com.Aditya.ParkingManagementSystem.exceptions.EnterExitGateIdException;
import com.Aditya.ParkingManagementSystem.exceptions.NoGateIdFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoTicketFoundException;
import com.Aditya.ParkingManagementSystem.factories.CalculatePricingStrategyFactory;
import com.Aditya.ParkingManagementSystem.models.*;
import com.Aditya.ParkingManagementSystem.repositories.BillRepository;
import com.Aditya.ParkingManagementSystem.repositories.TicketRepository;

public class BillService {
    BillRepository billRepository;
    TicketService ticketService;
    GateService gateService;
    PriceStrategy priceStrategy;
    ParkingSpotService parkingSpotService;
    public BillService(BillRepository billRepository, TicketService ticketService, GateService gateService,
                       ParkingSpotService parkingSpotService)
    {
        this.billRepository = billRepository;
        this.ticketService = ticketService;
        this.gateService = gateService;
        this.parkingSpotService = parkingSpotService;
    }
    public Bill generateBill(Long vehicleNumber, Long gateId) throws NoTicketFoundException, NoGateIdFoundException, EnterEntryGateIdException {
        Ticket ticket = ticketService.getTicketByVehicleNumber(vehicleNumber);

        if(ticket == null)
            throw new NoTicketFoundException("Ticket Not found! please check your vehicle number ");

        Gate gate = gateService.getGateByGateId(gateId);
        if(gate==null)
            throw new NoGateIdFoundException("No Gate Id Found");
        if(gate.getGateType().equals(GateType.Entry))
            throw new EnterEntryGateIdException("This gate is not available for exit go through another gate");

         priceStrategy = CalculatePricingStrategyFactory.getPricingStrategy();
        Integer amount = priceStrategy.calculatePrice(1000L,1500L);

        parkingSpotService.setParkingSpotStatusAvailable(ticket.getParkingSpot());

        return  billRepository.createBill(amount,ticket,gate);
    }
    public void displayBill(GenerateBillResponceDto responseDto)
    {
         Bill bill = responseDto.getBill();

        if(responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS))
        {
            System.out.println("your Bill generated successfully");
        }
        System.out.println("Bill Status : "+ bill.getBillStatus());
        System.out.println("Amount : "+bill.getAmount()+" Rs");
        System.out.println("VehicleNumber : "+bill.getTicket().getVehicle().getNumber());
        System.out.println("Ticket Id : "+bill.getTicket().getId());
        System.out.println("Operator Name : "+bill.getGate().getOperator().getName());
        System.out.println("Gate No : "+bill.getGate().getNumber());
        System.out.println("Exit Time : "+bill.getExitTime());
        System.out.println("Gate Type : "+bill.getGate().getGateType());
    }
}
