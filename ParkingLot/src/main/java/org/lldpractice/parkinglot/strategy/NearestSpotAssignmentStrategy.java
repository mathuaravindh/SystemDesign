package org.lldpractice.parkinglot.strategy;

import org.lldpractice.parkinglot.enums.SpotType;
import org.lldpractice.parkinglot.enums.VehicleType;
import org.lldpractice.parkinglot.helper.VehicleToSpotMapper;
import org.lldpractice.parkinglot.model.*;
import org.lldpractice.parkinglot.service.ParkingSpotService;
import org.lldpractice.parkinglot.service.ParkingTicketService;

import java.time.LocalDateTime;
import java.util.Optional;

public class NearestSpotAssignmentStrategy implements AssignmentStrategy{

    private final ParkingSpotService parkingSpotService;
    private final ParkingTicketService parkingTicketService;

    public NearestSpotAssignmentStrategy(ParkingSpotService parkingSpotService, ParkingTicketService parkingTicketService) {
        this.parkingSpotService = parkingSpotService;
        this.parkingTicketService = parkingTicketService;
    }

    @Override
    public Optional<ParkingTicket> assignParkingSpot(Vehicle vehicle, ParkingLot parkingLot)
    {
        Optional<ParkingSpot> nearestSpot = findNearestSpot(parkingLot, vehicle.getVehicletype());
        if(nearestSpot.isPresent()) {
            ParkingSpot selectedSpot = nearestSpot.get();
            parkingSpotService.markSpotOccupied(selectedSpot);
            return Optional.of(parkingTicketService.createParkingTicket(LocalDateTime.now(), selectedSpot, vehicle.getVehicletype(), vehicle.getVehicleNumber()));
        }
        return Optional.empty();

    }

    public Optional<ParkingSpot> findNearestSpot(ParkingLot parkingLot, VehicleType vehicleType)
    {
        SpotType spotTypeTobeAssigned = VehicleToSpotMapper.getSpotType(vehicleType);
        for (ParkingLevel parkingLevel : parkingLot.getParkinglevels())
        {
            if(parkingLevel.getAvailableSpots() != null && parkingLevel.getAvailableSpots().get(spotTypeTobeAssigned) != null && !parkingLevel.getAvailableSpots().get(spotTypeTobeAssigned).isEmpty())
                return Optional.of(parkingLevel.getAvailableSpots().get(spotTypeTobeAssigned).poll());
        }
        return Optional.empty();
    }
}
