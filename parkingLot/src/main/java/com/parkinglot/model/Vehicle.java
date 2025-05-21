package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;

public abstract class Vehicle {

    private final String licensePlate ;
    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public abstract VehicleType getType();



}
