package com.Aditya.ParkingManagementSystem.repositories;

import com.Aditya.ParkingManagementSystem.models.Bill;
import com.Aditya.ParkingManagementSystem.models.BillStatus;
import com.Aditya.ParkingManagementSystem.models.Gate;
import com.Aditya.ParkingManagementSystem.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {
    Map<Long,Bill> billMap = new HashMap<>();
    public  BillRepository(Map<Long,Bill>billMap)
    {
        this.billMap = billMap;
    }
    public Bill createBill(Integer amount, Ticket ticket, Gate gate)
    {
        Bill bill = new Bill(System.currentTimeMillis());
        bill.setBillStatus(BillStatus.UNPAID);
        bill.setAmount(amount);
        bill.setGate(gate);
        bill.setTicket(ticket);
        bill.setExitTime(System.currentTimeMillis());

        return bill;
    }
}
