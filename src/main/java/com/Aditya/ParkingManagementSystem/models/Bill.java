package com.Aditya.ParkingManagementSystem.models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Bill extends BaseEntity{
    private BillStatus billStatus;
    private Ticket ticket;
    private Integer amount;
    private Long exitTime;

    // WE SUPPORT PARTIAL PAYMENTS OTHERWISE ONLY PAYMENT OBJECT HERE INSTEAD OF LIST OF PAYMENTS OBJECT
    private List<Payment>paymentList;
    private Gate gate;

    public Bill(){}
    public Bill(Long uuid) {
        super(uuid);
    }


    public BillStatus getBillStatus() {
        return billStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Integer getAmount() {
        return amount;
    }

    public Long getExitTime() {
        return exitTime;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public Gate getGate() {
        return gate;
    }


    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = exitTime;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
