package org.lldpractice.parkinglot.model;

import org.lldpractice.parkinglot.enums.VehicleType;

public class Vehicle {
    String VehicleNumber;
    VehicleType Vehicletype;

    public Vehicle(String vehicleNumber, VehicleType vehicletype) {
        VehicleNumber = vehicleNumber;
        Vehicletype = vehicletype;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicletype() {
        return Vehicletype;
    }

    public void setVehicletype(VehicleType vehicletype) {
        Vehicletype = vehicletype;
    }
}
