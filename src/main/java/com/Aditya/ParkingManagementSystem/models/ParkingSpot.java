package com.Aditya.ParkingManagementSystem.models;

import java.util.List;

public class ParkingSpot extends BaseEntity{

    private Integer number;
    private Integer floorNo;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> vehicleTypeList;

    public ParkingSpot(Long uuid,Integer number,ParkingSpotStatus parkingSpotStatus,
                       List<VehicleType>vehicleTypeList,Integer floorNo) {
        super(uuid);
        this.number = number;
        this.vehicleTypeList = vehicleTypeList;
        this.parkingSpotStatus = parkingSpotStatus;
        this.floorNo = floorNo;
    }
    public ParkingSpot(Long uuid)
    {
        super(uuid);
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }
}
