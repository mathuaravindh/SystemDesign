package org.lldpractice.parkinglot.service;

import org.lldpractice.parkinglot.enums.PaymentStatus;
import org.lldpractice.parkinglot.model.ParkingLot;
import org.lldpractice.parkinglot.model.ParkingTicket;
import org.lldpractice.parkinglot.model.Payment;
import org.lldpractice.parkinglot.model.Vehicle;
import org.lldpractice.parkinglot.strategy.AssignmentStrategy;

import java.time.LocalDateTime;

public class ParkingManagementService {
    private final ParkingSpotService parkingSpotService;
    private final PaymentService paymentService;
    private final ParkingLevelService parkingLevelService;
    private final AssignmentStrategy assignmentStrategy;

    public ParkingManagementService(ParkingSpotService parkingSpotService, PaymentService paymentService, ParkingLevelService parkingLevelService, AssignmentStrategy assignmentStrategy) {
        this.parkingSpotService = parkingSpotService;
        this.paymentService = paymentService;
        this.parkingLevelService = parkingLevelService;
        this.assignmentStrategy = assignmentStrategy;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle, ParkingLot parkingLot)
    {
        return assignmentStrategy.assignParkingSpot(vehicle, parkingLot)
                .orElseThrow(() -> new RuntimeException("No Parking spot available for " + vehicle.getVehicletype()));


    }

    public ParkingTicket exitVehicle(ParkingTicket parkingTicket)
    {
        Payment payment = paymentService.createPayment(parkingTicket.getTicketId());
        payment.setPaymentStatus(PaymentStatus.SUCCESS);

        parkingTicket.setOutTime(LocalDateTime.now());
        parkingTicket.setAmount(paymentService.calculatePrice(parkingTicket));
        parkingTicket.setPayment(payment);

        parkingSpotService.markSpotVacant(parkingTicket.getSpot());
        parkingLevelService.addParkingSpot(parkingTicket.getSpot().getLevelNo(), parkingTicket.getSpot());

        return parkingTicket;
    }
}
