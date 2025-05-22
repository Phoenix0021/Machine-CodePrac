package com.hotelmanagementsystem.services;
 
import com.hotelmanagementsystem.model.HouseKeepingLog;

import java.util.*;

public class HouseKeepingLogService {

    // In-memory store for housekeeping logs
    private final List<HouseKeepingLog> logs = new ArrayList<>();

    /**
     * Log a housekeeping task
     */
    public void logTask(HouseKeepingLog log) {
        logs.add(log);
    }

    /**
     * Get all logs for a specific room
     */
    public List<HouseKeepingLog> logTasksByRoom(int roomNumber) {
        List<HouseKeepingLog> result = new ArrayList<>();
        for (HouseKeepingLog log : logs) {
            if (log.getRoomNumber() == roomNumber) {
                result.add(log);
            }
        }
        return result;
    }
}
