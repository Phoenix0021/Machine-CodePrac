package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public class Car  extends Vehicle{

    public Car(String licensePlate){
        super(licensePlate);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }


}
