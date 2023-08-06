package com.Aditya.ParkingManagementSystem;

import com.Aditya.ParkingManagementSystem.Strategy.RandomSpotAssignmentStrategy;
import com.Aditya.ParkingManagementSystem.Strategy.SpotAssignmentStrategy;
import com.Aditya.ParkingManagementSystem.controllers.TicketController;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketRequestDto;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketResponceDto;
import com.Aditya.ParkingManagementSystem.models.*;
import com.Aditya.ParkingManagementSystem.repositories.GateRepository;
import com.Aditya.ParkingManagementSystem.repositories.ParkingLotRepository;
import com.Aditya.ParkingManagementSystem.repositories.ParkingSpotRepository;
import com.Aditya.ParkingManagementSystem.repositories.VehicleRepository;
import com.Aditya.ParkingManagementSystem.services.*;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ParkingManageMentSystem {

    public static void fillRegistry(ObjectRegistry objectRegistry, Map<Long,Gate>gateMap, Map<Long,ParkingLot>parkingLotMap) {
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLotMap);
        GateRepository gateRepository = new GateRepository(gateMap);
        GateService gateService = new GateService(gateRepository);
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingSpotService, parkingLotService);
        TicketService ticketService = new TicketService(vehicleService,gateService,spotAssignmentStrategy);
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
        objectRegistry.register("gateRepository",gateRepository);

    }
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Map<Long,Operator>operatorMap = new HashMap<>();
        Map<Long,Gate>gateMap = new HashMap<>();
        List<Floor>floorList = new ArrayList<>();
        Map<Long,Floor>floorMap = new HashMap<>();
        Map<Long,ParkingLot>parkingLotMap = new HashMap<>();

        for(int i=1;i<=3;i++)
        {
            System.out.println("Enter the Name of operator "+ i);
            String name = scanner.next();

            Operator operator = new Operator(System.currentTimeMillis(),name);
            operatorMap.put(operator.getId(),operator);

            Gate gate = new Gate((long)i,i,GateStatus.AVAILABLE,GateType.Entry);
            gateMap.put(gate.getId(),gate);

            operator.setGate(gate);
            gate.setOperator(operator);
        }
        System.out.println("How many floors Yours parkingLot have?");
        int noOfFloors = scanner.nextInt();
        for(int i=0;i<noOfFloors;i++)
        {
            System.out.println("how many Parking Spot you have on floor "+i);
            Integer noOfParkingSpot = scanner.nextInt();
            List<ParkingSpot>parkingSpotList =  new ArrayList<>();
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

        ParkingLot parkingLot = new ParkingLot(System.currentTimeMillis(),"RG Parking",floorList,gateMap,"Sinhgad Vadgaon (bk)");
         parkingLotMap.put(parkingLot.getId(),parkingLot);


       // ObjectRegistry objectRegistry = new ObjectRegistry();
       //  fillRegistry(objectRegistry,gateMap,parkingLotMap);
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLotMap);
        GateRepository gateRepository = new GateRepository(gateMap);
        GateService gateService = new GateService(gateRepository);
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingSpotService, parkingLotService);
        TicketService ticketService = new TicketService(vehicleService,gateService,spotAssignmentStrategy);
        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Is there any vehicle on any gate [y/n]");
        String ans = scanner.next();

        while(ans.equals("y")) {
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

                   ticketController.displayTicket(responseDto);

            System.out.println("Is there any vehicle on any gate [y/n]");
            ans = scanner.next();
        }
    }
}