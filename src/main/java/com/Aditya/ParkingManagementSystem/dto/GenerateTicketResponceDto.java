package com.Aditya.ParkingManagementSystem.dto;

import com.Aditya.ParkingManagementSystem.models.ResponseStatus;
import com.Aditya.ParkingManagementSystem.models.Ticket;

public class GenerateTicketResponceDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
