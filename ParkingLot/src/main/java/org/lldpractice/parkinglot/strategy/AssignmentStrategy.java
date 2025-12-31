package org.lldpractice.parkinglot.strategy;

import org.lldpractice.parkinglot.model.ParkingLot;
import org.lldpractice.parkinglot.model.ParkingTicket;
import org.lldpractice.parkinglot.model.Vehicle;

import java.util.Optional;

public interface AssignmentStrategy {
    Optional<ParkingTicket> assignParkingSpot(Vehicle vehicle, ParkingLot parkingLot);
}
