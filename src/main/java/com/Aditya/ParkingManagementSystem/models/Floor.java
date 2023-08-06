package com.Aditya.ParkingManagementSystem.models;

import java.util.List;
import java.util.Map;

public class Floor extends BaseEntity{

 private  List<ParkingSpot>parkingSpotList;
 private Integer number;
 private FloorStatus floorStatus;

 public Floor(Long uuid) {
  super(uuid);
 }
public Floor(Long uuid, List<ParkingSpot>parkingSpotList, Integer number, FloorStatus floorStatus)
{
 super(uuid);
 this.number = number;
 this.floorStatus = floorStatus;
 this.parkingSpotList = parkingSpotList;
}

 public List<ParkingSpot> getParkingSpotList() {
  return parkingSpotList;
 }

 public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
  this.parkingSpotList = parkingSpotList;
 }

 public Integer getNumber() {
  return number;
 }

 public void setNumber(Integer number) {
  this.number = number;
 }

 public FloorStatus getFloorStatus() {
  return floorStatus;
 }

 public void setFloorStatus(FloorStatus floorStatus) {
  this.floorStatus = floorStatus;
 }
}
