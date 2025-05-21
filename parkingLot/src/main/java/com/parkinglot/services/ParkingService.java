package com.parkinglot.services;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingSlot;
import com.parkinglot.model.Vehicle;

public class ParkingService {
    private ParkingLot parkingLot;

    public void createParkingLot() {
        parkingLot = new ParkingLot("MyLot");

        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSlot(new ParkingSlot(101, VehicleType.CAR));
        floor1.addSlot(new ParkingSlot(102, VehicleType.BIKE));
        floor1.addSlot(new ParkingSlot(103, VehicleType.TRUCK));

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSlot(new ParkingSlot(201, VehicleType.CAR));
        floor2.addSlot(new ParkingSlot(202, VehicleType.BIKE));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingLot.getFloors().values()) {
            for (ParkingSlot slot : floor.getSlots()) {
                if (!slot.isOccupied() && slot.getSlotType() == vehicle.getType()) {
                    slot.setParkedVehicle(vehicle);
                    System.out.println("Parked at Floor " + floor.getFloorNumber() + ", Slot " + slot.getSlotId());
                    return true;
                }
            }
        }
        System.out.println("No available slot for: " + vehicle.getType());
        return false;
    }

    public boolean unparkVehicle(int floorNumber, int slotId) {
        ParkingFloor floor = parkingLot.getFloors().get(floorNumber);
        if (floor == null) {
            System.out.println("Invalid floor number.");
            return false;
        }

        for (ParkingSlot slot : floor.getSlots()) {
            if (slot.getSlotId() == slotId) {
                if (slot.isOccupied()) {
                    Vehicle v = slot.getParkedVehicle();
                    slot.setParkedVehicle(null);
                    System.out.println("Unparked vehicle: " + v.getLicensePlate().toString());
                    return true;
                } else {
                    System.out.println("Slot is already empty.");
                    return false;
                }
            }
        }

        System.out.println("Slot not found on floor.");
        return false;
    }
}
