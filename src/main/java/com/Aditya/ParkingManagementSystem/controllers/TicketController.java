package com.Aditya.ParkingManagementSystem.controllers;

import com.Aditya.ParkingManagementSystem.dto.GenerateTicketRequestDto;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketResponceDto;
import com.Aditya.ParkingManagementSystem.exceptions.EnterExitGateIdException;
import com.Aditya.ParkingManagementSystem.exceptions.NoGateIdFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoParkingLotFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoParkingSpotException;
import com.Aditya.ParkingManagementSystem.models.Gate;
import com.Aditya.ParkingManagementSystem.models.ParkingSpot;
import com.Aditya.ParkingManagementSystem.models.ResponseStatus;
import com.Aditya.ParkingManagementSystem.models.Ticket;
import com.Aditya.ParkingManagementSystem.services.TicketService;


public class TicketController {
    private TicketService ticketService;
     public TicketController(TicketService ticketService)
     {
         this.ticketService = ticketService;
     }
      public GenerateTicketResponceDto generateTicket(GenerateTicketRequestDto ticketRequestDto)
      {
          GenerateTicketResponceDto ticketResponseDto = new GenerateTicketResponceDto();

          try
          {
              Ticket ticket = ticketService.generateTicket(ticketRequestDto.getVehicleNumber(),
                      ticketRequestDto.getVehicleType(),ticketRequestDto.getGateId());

              ticketResponseDto.setTicket(ticket);
              ticketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
          }
          catch (NoParkingSpotException e) {
              System.out.println(e.getMessage());
              ticketResponseDto.setResponseStatus(ResponseStatus.FAIL);
          }
          catch (NoGateIdFoundException e) {
              System.out.println(e.getMessage());
              ticketResponseDto.setResponseStatus(ResponseStatus.FAIL);
          } catch (NoParkingLotFoundException e) {
              System.out.println(e.getMessage());
              ticketResponseDto.setResponseStatus(ResponseStatus.FAIL);
          } catch (EnterExitGateIdException e) {
              System.out.println(e.getMessage());
              ticketResponseDto.setResponseStatus(ResponseStatus.FAIL);
          }

          return ticketResponseDto;
      }
      public void displayTicket(GenerateTicketResponceDto responseDto)
      {
          ticketService.displayMyTicket(responseDto);
      }
}
