package com.parkinglot.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.parkinglot.model.Receipt;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;

/**
 * One service responsible for:
 *   1. Creating a Ticket when a vehicle parks
 *   2. Closing the Ticket and issuing a Receipt when the vehicle exits
 */
public class TicketingService {

     private final Map<String, Ticket> activeTickets = new HashMap<>();
 
    public Ticket createTicket(Vehicle vehicle, int floorNumber, int slotId) {
        String ticketNo = generateId("TCK");
        Ticket ticket = new Ticket(ticketNo, vehicle, floorNumber, slotId);
        activeTickets.put(ticketNo, ticket);
        return ticket;
    }

    /**
     * Close a ticket and generate a receipt.
     * Returns null if ticket number is invalid.
     */
    public Receipt closeTicket(String ticketNumber, double hourlyRate) {
        Ticket ticket = activeTickets.remove(ticketNumber);
        if (ticket == null) {
            return null; // Invalid ticket
        }

        LocalDateTime exitTime = LocalDateTime.now();
        long minutes = Duration.between(ticket.getEntryTime(), exitTime).toMinutes();
        double amount = calculateFee(minutes, hourlyRate);

        return new Receipt(
                generateId("RCPT"),
                ticketNumber,
                ticket.getEntryTime(),
                exitTime,
                amount
        );
    }

 
    private double calculateFee(long minutes, double hourlyRate) {
        long hours = (minutes + 59) / 60;   
        return hours * hourlyRate;
    }

    private String generateId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
