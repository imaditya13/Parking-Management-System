package com.Aditya.ParkingManagementSystem.dto;

import com.Aditya.ParkingManagementSystem.models.Bill;
import com.Aditya.ParkingManagementSystem.models.BillStatus;
import com.Aditya.ParkingManagementSystem.models.ResponseStatus;

public class GenerateBillResponceDto {
    private Bill bill;
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
