package com.Aditya.ParkingManagementSystem.controllers;

import com.Aditya.ParkingManagementSystem.dto.GenerateBillRequestDto;
import com.Aditya.ParkingManagementSystem.dto.GenerateBillResponceDto;
import com.Aditya.ParkingManagementSystem.exceptions.EnterEntryGateIdException;
import com.Aditya.ParkingManagementSystem.exceptions.NoGateIdFoundException;
import com.Aditya.ParkingManagementSystem.exceptions.NoTicketFoundException;
import com.Aditya.ParkingManagementSystem.models.Bill;
import com.Aditya.ParkingManagementSystem.models.ResponseStatus;
import com.Aditya.ParkingManagementSystem.services.BillService;

public class BillController {
    BillService billService;
    public BillController(BillService billService)
    {
        this.billService = billService;
    }
 public GenerateBillResponceDto generateBill(GenerateBillRequestDto requestDto)  {
        GenerateBillResponceDto responseDto = new GenerateBillResponceDto();

        try {
          Bill  bill = billService.generateBill(requestDto.getVehicleNumber(),requestDto.getGateId());
            responseDto.setBill(bill);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (NoTicketFoundException e) {
            System.out.println(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.FAIL);
        } catch (NoGateIdFoundException e) {
            System.out.println(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.FAIL);
        } catch (EnterEntryGateIdException e) {
            System.out.println(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.FAIL);
        }

     return responseDto;
 }
    public void displayBill(GenerateBillResponceDto responseDto)
    {
        billService.displayBill(responseDto);
    }
}
