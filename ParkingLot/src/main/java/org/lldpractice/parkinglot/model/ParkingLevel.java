package org.lldpractice.parkinglot.model;

import org.lldpractice.parkinglot.enums.SpotType;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ParkingLevel {
    private String LevelNo;

    private HashMap<SpotType, PriorityQueue<ParkingSpot>> availableSpots;

    public ParkingLevel(String levelNo) {
        LevelNo = levelNo;
        availableSpots = new HashMap<>();
    }

    public String getLevelNo() {
        return LevelNo;
    }

    public void setLevelNo(String levelNo) {
        LevelNo = levelNo;

    }

    public HashMap<SpotType, PriorityQueue<ParkingSpot>> getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(HashMap<SpotType, PriorityQueue<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
    }
}
