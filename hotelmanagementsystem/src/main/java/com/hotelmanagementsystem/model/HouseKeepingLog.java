package com.hotelmanagementsystem.model;

import java.util.Date;

public class HouseKeepingLog {

    private String logId;
    private boolean isCompleted;
    private String description;
    private Date logTime;
    private int roomNumber;


    public HouseKeepingLog(String logId, boolean isCompleted, String description, Date logTime) {
        this.logId = logId;
        this.isCompleted = isCompleted;
        this.description = description;
        this.logTime = logTime;
        this.roomNumber = roomNumber;
    }

     
     

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getLogId() {
        return logId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

}
