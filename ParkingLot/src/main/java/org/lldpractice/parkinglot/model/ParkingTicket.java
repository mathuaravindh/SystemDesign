package org.lldpractice.parkinglot.model;

import org.lldpractice.parkinglot.enums.VehicleType;

import java.time.LocalDateTime;

public class ParkingTicket {
    int ticketId;
    String vehicleNumber;
    VehicleType vehicleType;
    ParkingSpot spot;
    LocalDateTime inTime;
    LocalDateTime outTime;
    Integer Amount;
    Payment payment;



    public ParkingTicket(LocalDateTime inTime, ParkingSpot spot, VehicleType vehicleType, String vehicleNumber, int ticketId)
    {
        this.inTime = inTime;
        this.spot = spot;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
