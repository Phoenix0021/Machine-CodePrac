package com.parkinglot.model;

import java.util.ArrayList;
import java.util.List;


public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void addSlot(ParkingSlot slot) {
        this.slots.add(slot);
    }
}
