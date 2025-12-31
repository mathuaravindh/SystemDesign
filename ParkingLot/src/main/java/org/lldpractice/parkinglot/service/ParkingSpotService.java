package org.lldpractice.parkinglot.service;

import org.lldpractice.parkinglot.enums.SpotStatus;
import org.lldpractice.parkinglot.enums.SpotType;
import org.lldpractice.parkinglot.model.ParkingLevel;
import org.lldpractice.parkinglot.model.ParkingSpot;

public class ParkingSpotService {
    public ParkingSpot createParkingSpot(int spotId, SpotType spotType, int distanceFromEntrance, ParkingLevel parkingLevel, SpotStatus spotStatus)
    {
        return  new ParkingSpot(spotId, spotType, distanceFromEntrance, parkingLevel, spotStatus);
    }

    public void markSpotOccupied(ParkingSpot parkingSpot)
    {
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
    }

    public void markSpotVacant(ParkingSpot parkingSpot)
    {
        parkingSpot.setSpotStatus(SpotStatus.VACANT);
    }
}
