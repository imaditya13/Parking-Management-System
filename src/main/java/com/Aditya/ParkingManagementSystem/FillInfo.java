package com.Aditya.ParkingManagementSystem;


import com.Aditya.ParkingManagementSystem.controllers.BillController;
import com.Aditya.ParkingManagementSystem.controllers.TicketController;
import com.Aditya.ParkingManagementSystem.dto.GenerateBillRequestDto;
import com.Aditya.ParkingManagementSystem.dto.GenerateBillResponceDto;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketRequestDto;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketResponceDto;
import com.Aditya.ParkingManagementSystem.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FillInfo {
    Scanner scanner = new Scanner(System.in);
    public  void operatorAndGateInfo(Map<Long,Operator>operatorMap, Map<Long,Gate>gateMap) {
        for(int i=1;i<=2;i++)
        {
            System.out.println("Enter the Name of operator "+ i);
            String name = scanner.next();

            Operator operator = new Operator(System.currentTimeMillis(),name);
            operatorMap.put(operator.getId(),operator);

            System.out.println("Which gate assign to operator "+operator.getName());
            String gateName = scanner.next();

            GateType gateType = GateType.Entry;

            if(gateName.equals("exit"))
            {
                gateType = GateType.Exit;
            }


            Gate gate = new Gate((long)i,i, GateStatus.AVAILABLE,gateType);
            gateMap.put(gate.getId(),gate);

            operator.setGate(gate);
            gate.setOperator(operator);
        }
    }
    public void floorAndParkingSpotInfo(List<Floor>floorList)
    {
        System.out.println("How many floors Yours parkingLot have?");
        int noOfFloors = scanner.nextInt();
        for(int i=0;i<noOfFloors;i++)
        {
            System.out.println("how many Parking Spot you have on floor "+i);
            Integer noOfParkingSpot = scanner.nextInt();
            List<ParkingSpot> parkingSpotList =  new ArrayList<>();
            for(int j=1;j<=noOfParkingSpot;j++)
            {
                //System.out.println("Please Enter ParkingSpot "+j+" supported Vehicles");
                List<VehicleType>vehicleTypes = new ArrayList<>(List.of(VehicleType.AUTO,VehicleType.BUS,VehicleType.SEDAN,VehicleType.SUV,VehicleType.MOTORCYCLE));
                ParkingSpot parkingSpot = new ParkingSpot(System.currentTimeMillis(),j,ParkingSpotStatus.AVAILABLE,vehicleTypes,i);
                parkingSpotList.add(parkingSpot);
            }
            Floor floor = new Floor(System.currentTimeMillis(),parkingSpotList,i,FloorStatus.AVAILABLE);
            floorList.add(floor);
        }
    }
    public GenerateBillResponceDto fillExitGateInfo(BillController billController) {
        System.out.println("Enter gate number that your car exit : ");
        Long gateNo = scanner.nextLong();
        System.out.println("Enter your vehicle number : ");
        Long vehicleNo = scanner.nextLong();

        GenerateBillRequestDto requestDto = new GenerateBillRequestDto();
        requestDto.setGateId(gateNo);
        requestDto.setVehicleNumber(vehicleNo);

         GenerateBillResponceDto responseDto = billController.generateBill(requestDto);
         return responseDto;
    }
    public  GenerateTicketResponceDto fillEntryGateInfo(TicketController ticketController) {

        System.out.println("Enter gate number that your car enter: ");
        Long gateNo = scanner.nextLong();
        System.out.println("Enter your vehicle number : ");
        Long vehicleNo = scanner.nextLong();
        System.out.println("Enter your vehicle type : ");
        String vehicleType = scanner.next();



        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(gateNo);
        requestDto.setVehicleNumber(vehicleNo);
        requestDto.setVehicleType(VehicleType.SUV);

        GenerateTicketResponceDto responseDto =ticketController.generateTicket(requestDto);

        return responseDto;
       // ticketController.displayTicket(responseDto);
    }

    public  void fillRegistry(ObjectRegistry objectRegistry, Map<Long,Gate>gateMap, Map<Long,ParkingLot>parkingLotMap) {
      /*  VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLotMap);
        GateRepository gateRepository = new GateRepository(gateMap);
        GateService gateService = new GateService(gateRepository);
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingSpotService, parkingLotService);
        TicketService ticketService = new TicketService(vehicleService,gateService,spotAssignmentStrategy,);
        TicketController ticketController = new TicketController(ticketService);

        objectRegistry.register("vehicleRepository",vehicleRepository);
        objectRegistry.register("parkingSpotRepository",parkingSpotRepository);
        objectRegistry.register("parkingLotRepository",parkingLotRepository);
        objectRegistry.register("gateService",gateService);
        objectRegistry.register("parkingLotService",parkingLotService);
        objectRegistry.register("parkingSpotService",parkingSpotService);
        objectRegistry.register("vehicleService",vehicleService);
        objectRegistry.register("spotAssignmentStrategy",spotAssignmentStrategy);
        objectRegistry.register("ticketService",ticketService);
        objectRegistry.register("ticketController",ticketController);
        objectRegistry.register("gateRepository",gateRepository);*/

    }
}
