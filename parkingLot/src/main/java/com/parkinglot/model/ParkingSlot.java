package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public class ParkingSlot {
    private int slotId;
    private VehicleType slotType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSlot(int slotId, VehicleType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = (vehicle != null);
    }
}