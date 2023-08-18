package com.Aditya.ParkingManagementSystem;

import com.Aditya.ParkingManagementSystem.Strategy.SpotAssignmentStrategy.RandomSpotAssignmentStrategy;
import com.Aditya.ParkingManagementSystem.Strategy.SpotAssignmentStrategy.SpotAssignmentStrategy;
import com.Aditya.ParkingManagementSystem.controllers.BillController;
import com.Aditya.ParkingManagementSystem.controllers.TicketController;
import com.Aditya.ParkingManagementSystem.dto.GenerateBillResponceDto;
import com.Aditya.ParkingManagementSystem.dto.GenerateTicketResponceDto;
import com.Aditya.ParkingManagementSystem.exceptions.NoTicketFoundException;
import com.Aditya.ParkingManagementSystem.models.*;
import com.Aditya.ParkingManagementSystem.repositories.*;
import com.Aditya.ParkingManagementSystem.services.*;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ParkingManageMentSystem {


    public static void main(String[] args) throws NoTicketFoundException {

            FillInfo fillInfo = new FillInfo();
        Scanner scanner = new Scanner(System.in);
        Map<Long,Operator>operatorMap = new HashMap<>();
        Map<Long,Gate>gateMap = new HashMap<>();
        List<Floor>floorList = new ArrayList<>();
        Map<Long,Ticket>ticketMap = new HashMap<>();
        Map<Long,ParkingLot>parkingLotMap = new HashMap<>();
        Map<Long,Bill>billMap = new HashMap<>();
        fillInfo.operatorAndGateInfo(operatorMap,gateMap);

        fillInfo.floorAndParkingSpotInfo(floorList);

        //createParkingLot
        ParkingLot parkingLot = new ParkingLot(System.currentTimeMillis(),"RG Parking",floorList,gateMap,"Sinhgad Vadgaon (bk)");
         parkingLotMap.put(parkingLot.getId(),parkingLot);


      // ObjectRegistry objectRegistry = new ObjectRegistry();
       // fillInfo.fillRegistry(objectRegistry,gateMap,parkingLotMap);

        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(parkingLotMap);
        GateRepository gateRepository = new GateRepository(gateMap);
        GateService gateService = new GateService(gateRepository);
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingSpotService, parkingLotService);
        TicketRepository ticketRepository = new TicketRepository(ticketMap);
        TicketService ticketService = new TicketService(vehicleService,gateService,parkingSpotService,spotAssignmentStrategy,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        BillRepository billRepository = new BillRepository(billMap);
        BillService billService = new BillService(billRepository,ticketService,gateService,parkingSpotService);
        BillController billController = new BillController(billService);

        String ans = "y";

        while(ans.equals("y")) {

            System.out.println("Is there any vehicle on any gate [y/n]");
            ans = scanner.next();
            if(ans.equals("n"))break;

           System.out.println("which gate[entry/exit]");
           String g = scanner.next();

           if(g.equals("exit"))
           {
              GenerateBillResponceDto billResponseDto = fillInfo.fillExitGateInfo(billController);
             billController.displayBill(billResponseDto);
           }
           else
            {
               GenerateTicketResponceDto ticketResponseDto = fillInfo.fillEntryGateInfo(ticketController);
                System.out.println("you want Ticket [y/n]");
                String s = scanner.next();
                if(s.equals("y")) ticketController.displayTicket(ticketResponseDto);
            }
        }
    }
}