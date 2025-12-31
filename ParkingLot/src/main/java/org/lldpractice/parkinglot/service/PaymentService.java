package org.lldpractice.parkinglot.service;

import org.lldpractice.parkinglot.config.PricingConfig;
import org.lldpractice.parkinglot.config.SpotPricing;
import org.lldpractice.parkinglot.enums.PaymentStatus;
import org.lldpractice.parkinglot.enums.SpotType;
import org.lldpractice.parkinglot.model.ParkingTicket;
import org.lldpractice.parkinglot.model.Payment;

import java.time.Duration;
import java.time.LocalDateTime;

public class PaymentService {
    public int calculatePrice(ParkingTicket ticket) {

        if (ticket.getOutTime() == null) {
            throw new IllegalStateException("Vehicle has not exited yet");
        }

        LocalDateTime inTime = ticket.getInTime();
        LocalDateTime outTime = ticket.getOutTime();

        long totalHours = Duration.between(inTime, outTime).toHours();

        SpotType spotType = ticket.getSpot().getSpotType();
        SpotPricing pricing = PricingConfig.getPricing(spotType);

        return totalHours < 1 ? pricing.getMinimumCharge() :
                + (int) (totalHours * pricing.getPerHourChange());
    }

    public Payment createPayment(int ticketId)
    {
        return new Payment(ticketId, PaymentStatus.PENDING);
    }

}
