package org.lldpractice.parkinglot.config;

public class SpotPricing {
    final int minimumCharge;
    final int perHourChange;

    public SpotPricing(int minimumCharge, int perHourChange) {
        this.minimumCharge = minimumCharge;
        this.perHourChange = perHourChange;
    }

    public int getMinimumCharge() {
        return minimumCharge;
    }

    public int getPerHourChange() {
        return perHourChange;
    }
}
