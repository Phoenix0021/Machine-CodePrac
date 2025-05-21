package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public class Truck  extends Vehicle{

    public Truck(String licensePlate){
        super(licensePlate);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

}
