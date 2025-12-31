package org.lldpractice.parkinglot;

import org.lldpractice.parkinglot.enums.SpotStatus;
import org.lldpractice.parkinglot.enums.SpotType;
import org.lldpractice.parkinglot.enums.VehicleType;
import org.lldpractice.parkinglot.model.*;
import org.lldpractice.parkinglot.service.*;
import org.lldpractice.parkinglot.strategy.AssignmentStrategy;
import org.lldpractice.parkinglot.strategy.NearestSpotAssignmentStrategy;


public class Main {
    static void main() {
        ParkingLotService parkingLotService = new ParkingLotService();
        ParkingLevelService parkingLevelService = new ParkingLevelService();
        ParkingSpotService parkingSpotService = new ParkingSpotService();
        ParkingTicketService parkingTicketService = new ParkingTicketService();
        PaymentService paymentService = new PaymentService();


        ParkingLevel parkingLevel1 = parkingLevelService.createParkingLevel("L1");
        ParkingLevel parkingLevel2 = parkingLevelService.createParkingLevel("L2");

        ParkingSpot parkingSpot1 = parkingSpotService.createParkingSpot(1, SpotType.SMALL, 3, parkingLevel1, SpotStatus.VACANT);
        ParkingSpot parkingSpot2 = parkingSpotService.createParkingSpot(2, SpotType.MEDIUM, 2, parkingLevel1, SpotStatus.VACANT);
        ParkingSpot parkingSpot3 = parkingSpotService.createParkingSpot(3, SpotType.LARGE, 5, parkingLevel1, SpotStatus.VACANT);

        parkingLevelService.addParkingSpot(parkingLevel1, parkingSpot1);
        parkingLevelService.addParkingSpot(parkingLevel1, parkingSpot2);
        parkingLevelService.addParkingSpot(parkingLevel1, parkingSpot3);

        ParkingLot parkingLot = parkingLotService.createParkingLot("PL1");
        parkingLotService.addParkingLevel(parkingLot, parkingLevel1);
        parkingLotService.addParkingLevel(parkingLot, parkingLevel2);

        AssignmentStrategy nearestSpotAssignmentStrategy = new NearestSpotAssignmentStrategy(parkingSpotService, parkingTicketService);
        ParkingManagementService parkingManagementService = new ParkingManagementService(parkingSpotService, paymentService, parkingLevelService, nearestSpotAssignmentStrategy);

        Vehicle vehicle = new Vehicle("DL123", VehicleType.HATCHBACK);
        ParkingTicket parkingTicket = parkingManagementService.parkVehicle(vehicle, parkingLot);


        System.out.println("ParkingSpot Assigned");
        System.out.println(parkingTicket.getTicketId());
        System.out.println(parkingTicket.getInTime());
        System.out.println(parkingTicket.getSpot().getSpotId());
        System.out.println(parkingTicket.getVehicleNumber());


        System.out.println("------------------------------------------------------");


        parkingTicket = parkingManagementService.exitVehicle(parkingTicket);
        System.out.println("Vehicle Exited");
        System.out.println(parkingTicket.getTicketId());
        System.out.println(parkingTicket.getInTime());
        System.out.println(parkingTicket.getSpot().getSpotId());
        System.out.println(parkingTicket.getVehicleNumber());
        System.out.println(parkingTicket.getOutTime());
        System.out.println("Amt : " + parkingTicket.getAmount());
        System.out.println("Payment Status : " + parkingTicket.getPayment().getPaymentStatus());


        System.out.println("------------------------------------------------------");

        parkingTicket = parkingManagementService.parkVehicle(vehicle, parkingLot);


        System.out.println("ParkingSpot Assigned");
        System.out.println(parkingTicket.getTicketId());
        System.out.println(parkingTicket.getInTime());
        System.out.println(parkingTicket.getSpot().getSpotId());
        System.out.println(parkingTicket.getVehicleNumber());


        System.out.println("------------------------------------------------------");

        parkingManagementService.parkVehicle(vehicle, parkingLot);
    }
}
