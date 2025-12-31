package org.lldpractice.parkinglot.model;

import org.lldpractice.parkinglot.enums.PaymentStatus;

public class Payment {
    int ticketId;
    PaymentStatus paymentStatus;

    public Payment(int ticketId, PaymentStatus paymentStatus) {
        this.ticketId = ticketId;
        this.paymentStatus = paymentStatus;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


}
