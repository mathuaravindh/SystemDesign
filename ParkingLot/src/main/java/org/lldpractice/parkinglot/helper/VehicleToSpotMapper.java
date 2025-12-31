package org.lldpractice.parkinglot.helper;

import org.lldpractice.parkinglot.enums.SpotType;
import org.lldpractice.parkinglot.enums.VehicleType;

public class VehicleToSpotMapper {
    public static SpotType getSpotType(VehicleType vehicleType)
    {
        if(vehicleType == VehicleType.MOTORCYCLE || vehicleType == VehicleType.HATCHBACK)
            return SpotType.SMALL;
        else if(vehicleType == VehicleType.SEDAN || vehicleType == VehicleType.SUV)
            return SpotType.MEDIUM;
        else
            return SpotType.LARGE;
    }
}
