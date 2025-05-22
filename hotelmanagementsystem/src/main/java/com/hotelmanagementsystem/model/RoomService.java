package com.hotelmanagementsystem.model;

import java.util.*; 

public class RoomService {
    private String serviceId;
    private String description;
    private double cost;
    private Date serviceTime;
    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public RoomService(String serviceId, String description, double cost, Date serviceTime) {
        this.serviceId = serviceId;
        this.description = description;
        this.cost = cost;
        this.serviceTime = serviceTime;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Date getServiceTime() {
        return serviceTime;
    }
    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }
    
}
