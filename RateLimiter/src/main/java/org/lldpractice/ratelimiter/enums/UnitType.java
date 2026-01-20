package org.lldpractice.ratelimiter.enums;

public enum UnitType {
    SECONDS(1000L),
    MINUTES(60_000L),
    HOURS(3_600_000L);

    private final long millis;

    UnitType(long millis)
    {
        this.millis = millis;
    }

    public long toMillis(int time) {
        return time * millis;
    }
}
