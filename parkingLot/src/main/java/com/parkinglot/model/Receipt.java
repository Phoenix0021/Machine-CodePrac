package com.parkinglot.model;
 

import java.time.LocalDateTime;

public class Receipt {
    private String receiptNumber;
    private String ticketNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amountPaid;

    public Receipt(String receiptNumber, String ticketNumber, LocalDateTime entryTime, LocalDateTime exitTime, double amountPaid) {
        this.receiptNumber = receiptNumber;
        this.ticketNumber = ticketNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.amountPaid = amountPaid;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}
