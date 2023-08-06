package com.Aditya.ParkingManagementSystem.models;

import java.util.List;
import java.util.Map;

public class ParkingLot extends BaseEntity {
   private List<Floor>floorList;
   private Map<Long, Gate> gateMap;
   private String name;
   private String address;

   public ParkingLot(Long uuid, String name,  List<Floor>floorList, Map<Long, Gate> gateMap, String address) {
      super(uuid);
      this.name = name;
      this.floorList = floorList;
      this.address = address;
      this.gateMap = gateMap;
   }
   public ParkingLot(String name,Long uuid)
   {
      super(uuid);
      this.name = name;
   }

   public List<Floor> getFloorList() {
      return floorList;
   }

   public void setFloorList(List<Floor> floorList) {
      this.floorList = floorList;
   }

   public Map<Long, Gate> getGateMap() {
      return gateMap;
   }

   public void setGateMap(Map<Long, Gate> gateMap) {
      this.gateMap = gateMap;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}
