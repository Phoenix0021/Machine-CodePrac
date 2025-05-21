package com.parkinglot.model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String name;
    private Map<Integer, ParkingFloor> floors;

    public ParkingLot(String name) {
        this.name = name;
        this.floors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Integer, ParkingFloor> getFloors() {
        return floors;
    }

    public void addFloor(ParkingFloor floor) {
        this.floors.put(floor.getFloorNumber(), floor);
    }
}
