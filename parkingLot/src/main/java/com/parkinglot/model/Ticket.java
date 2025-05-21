package com.parkinglot.model;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketNumber;
    private Vehicle vehicle;
    private int floorNumber;
    private int slotId;
    private LocalDateTime entryTime;

    public Ticket(String ticketNumber, Vehicle vehicle, int floorNumber, int slotId) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.slotId = slotId;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotId() {
        return slotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}