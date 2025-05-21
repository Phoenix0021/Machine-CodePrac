package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public class Bike extends Vehicle{

    public Bike(String licensePlate){
        super(licensePlate);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }

}
