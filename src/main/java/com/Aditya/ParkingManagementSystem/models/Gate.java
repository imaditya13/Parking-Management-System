package com.Aditya.ParkingManagementSystem.models;

public class Gate extends BaseEntity{
    private GateType gateType;
    private Integer number;
    private GateStatus gateStatus;
    private  Operator operator;

    public Gate(Long uuid) {
        super(uuid);
    }
    public Gate(Long uuid, Integer number, GateStatus gateStatus, GateType gateType)
    {
        super(uuid);
        this.gateStatus = gateStatus;
        this.number = number;
        this.gateType = gateType;
    }


    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
