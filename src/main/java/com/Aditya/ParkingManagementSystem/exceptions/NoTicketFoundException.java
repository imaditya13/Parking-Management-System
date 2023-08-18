package com.Aditya.ParkingManagementSystem.exceptions;

public class NoTicketFoundException extends  Exception{
    public NoTicketFoundException(String message)
    {
        super((message));
    }
}
