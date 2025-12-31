package org.lldpractice.parkinglot.model;

import org.lldpractice.parkinglot.enums.SpotStatus;
import org.lldpractice.parkinglot.enums.SpotType;

public class ParkingSpot {
    int spotId;
    SpotType spotType;
    int distanceFromEntrance;
    ParkingLevel level;
    SpotStatus spotStatus;

    public ParkingSpot(int spotId, SpotType spotType, int distanceFromEntrance, ParkingLevel level, SpotStatus spotStatus) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.distanceFromEntrance = distanceFromEntrance;
        this.level = level;
        this.spotStatus = spotStatus;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public int getDistanceFromEntrance() {
        return distanceFromEntrance;
    }

    public void setDistanceFromEntrance(int distanceFromEntrance) {
        this.distanceFromEntrance = distanceFromEntrance;
    }

    public ParkingLevel getLevelNo() {
        return level;
    }

    public void setLevelNo(ParkingLevel level) {
        this.level = level;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }
}
