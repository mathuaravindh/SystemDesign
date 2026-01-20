package org.lldpractice.ratelimiter.config;

import org.lldpractice.ratelimiter.enums.UnitType;

public class Limit {
    private final int time;
    private final UnitType unitType;  //sec, minutes, hours
    private final int maxRequests;

    public Limit(int time, UnitType unitType, int maxRequests) {
        this.time = time;
        this.unitType = unitType;
        this.maxRequests = maxRequests;
    }

    public int getTime() {
        return time;
    }


    public UnitType getUnitType() {
        return unitType;
    }


    public int getMaxRequests() {
        return maxRequests;
    }

    public long windowSizeMillis()
    {
        return unitType.toMillis(time);
    }
}
