package org.lldpractice.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<ParkingLevel> parkinglevels;

    public ParkingLot(String name) {
        this.name = name;
        parkinglevels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingLevel> getParkinglevels() {
        return parkinglevels;
    }

    public void setParkinglevels(List<ParkingLevel> parkinglevels) {
        this.parkinglevels = parkinglevels;
    }

    public void addLevel(ParkingLevel level)
    {
        this.parkinglevels.add(level);
    }
}
