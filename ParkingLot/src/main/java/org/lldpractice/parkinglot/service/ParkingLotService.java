package org.lldpractice.parkinglot.service;

import org.lldpractice.parkinglot.model.ParkingLevel;
import org.lldpractice.parkinglot.model.ParkingLot;

public class ParkingLotService {

    public ParkingLot createParkingLot(String name)
    {
        return new ParkingLot(name);
    }

    public void addParkingLevel(ParkingLot parkingLot, ParkingLevel parkingLevel)
    {
        parkingLot.addLevel(parkingLevel);
    }
}
