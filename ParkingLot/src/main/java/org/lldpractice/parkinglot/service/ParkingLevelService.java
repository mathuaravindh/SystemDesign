package org.lldpractice.parkinglot.service;

import org.lldpractice.parkinglot.enums.SpotType;
import org.lldpractice.parkinglot.model.ParkingLevel;
import org.lldpractice.parkinglot.model.ParkingSpot;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ParkingLevelService {

    public ParkingLevel createParkingLevel(String levelNo)
    {
        return new ParkingLevel(levelNo);
    }

    public void addParkingSpot(ParkingLevel parkingLevel, ParkingSpot parkingSpot)
    {
        if(!parkingLevel.getAvailableSpots().containsKey(parkingSpot.getSpotType())) {
            HashMap<SpotType, PriorityQueue<ParkingSpot>> map = parkingLevel.getAvailableSpots();
            PriorityQueue<ParkingSpot> pq = new PriorityQueue<>(
                    (a, b) -> a.getDistanceFromEntrance() - b.getDistanceFromEntrance());
            pq.offer(parkingSpot);
            map.put(parkingSpot.getSpotType(), pq);
            parkingLevel.setAvailableSpots(map);
        }
        else {
           PriorityQueue<ParkingSpot> pq = parkingLevel.getAvailableSpots().get(parkingSpot.getSpotType());
           pq.offer(parkingSpot);
        }
    }
}
