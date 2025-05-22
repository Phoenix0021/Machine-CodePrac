package com.hotelmanagementsystem.model;

import com.hotelmanagementsystem.enums.RoomStatus;
import com.hotelmanagementsystem.enums.RoomType;

public class HotelRoom {
    private int roomNumber;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private double price;
    
    public HotelRoom(int roomNumber, RoomType roomType, RoomStatus roomStatus, double price){
        this.roomNumber =roomNumber;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.price = price;
    }


    public int getRoomNumber(){
        return roomNumber;
    }

    public RoomType getRoomType(){
        return roomType;
    }

    public RoomStatus getRoomStatus(){
        return roomStatus;
    }

    public double getPrice(){
        return price;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
