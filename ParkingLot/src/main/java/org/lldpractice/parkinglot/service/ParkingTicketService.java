package org.lldpractice.parkinglot.service;

import org.lldpractice.parkinglot.enums.VehicleType;
import org.lldpractice.parkinglot.model.ParkingSpot;
import org.lldpractice.parkinglot.model.ParkingTicket;

import java.time.LocalDateTime;
import java.util.Random;


public class ParkingTicketService {
    public ParkingTicket createParkingTicket(LocalDateTime inTime, ParkingSpot spot, VehicleType vehicleType, String vehicleNumber)
    {
        Random random = new Random();
        int ticketId = random.nextInt(Integer.MAX_VALUE);
        return new ParkingTicket(inTime, spot, vehicleType, vehicleNumber, ticketId);
    }
}
