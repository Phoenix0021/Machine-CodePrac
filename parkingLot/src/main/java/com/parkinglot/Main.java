package com.parkinglot;

import java.util.Scanner;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.Bike;
import com.parkinglot.model.Car;
import com.parkinglot.model.Receipt;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Truck;
import com.parkinglot.model.Vehicle;
import com.parkinglot.services.ParkingService;
import com.parkinglot.services.TicketingService;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingService parkingService = new ParkingService();
        TicketingService ticketingService = new TicketingService();
        parkingService.createParkingLot();

        while (true) {
            System.out.println("\n1. Park Vehicle\n2. Unpark Vehicle\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            if (choice == 1) {
                System.out.println("Enter Vehicle Type (CAR, BIKE, TRUCK): ");
                String typeStr = sc.nextLine();
                VehicleType type = VehicleType.valueOf(typeStr.toUpperCase());

                System.out.println("Enter License Plate: ");
                String license = sc.nextLine();

                Vehicle vehicle;
                switch (type) {
                    case CAR:
                        vehicle = new Car(license);
                        break;
                    case BIKE:
                        vehicle = new Bike(license);
                        break;
                    case TRUCK:
                        vehicle = new Truck(license);
                        break;
                    default:
                        System.out.println("Invalid vehicle type");
                        continue;
                }

                // Call parkVehicle (boolean)
                boolean parked = parkingService.parkVehicle(vehicle);

                if (parked) {
                    System.out.println("Vehicle parked successfully.");
                    // Ask user to input floor and slot to create ticket (since we can't get from parkVehicle)
                    System.out.println("Enter floor number where vehicle is parked: ");
                    int floor = sc.nextInt();
                    System.out.println("Enter slot number where vehicle is parked: ");
                    int slot = sc.nextInt();
                    sc.nextLine(); // consume newline

                    // Create ticket manually with floor, slot info
                    Ticket ticket = ticketingService.createTicket(vehicle, floor, slot);
                    System.out.println("Ticket created. Ticket Number: " + ticket.getTicketNumber());
                } else {
                    System.out.println("Parking failed. No available slot.");
                }

            } else if (choice == 2) {
                System.out.println("Enter floor number to unpark from: ");
                int floor = sc.nextInt();
                System.out.println("Enter slot number to unpark from: ");
                int slot = sc.nextInt();
                sc.nextLine(); // consume newline

                boolean success = parkingService.unparkVehicle(floor, slot);

                if (success) {
                    System.out.println("Vehicle unparked successfully.");

                    System.out.println("Enter ticket number to close: ");
                    String ticketNo = sc.nextLine();

                    System.out.println("Enter hourly rate: ");
                    double rate = sc.nextDouble();
                    sc.nextLine(); // consume newline

                    Receipt receipt = ticketingService.closeTicket(ticketNo, rate);
                    if (receipt != null) {
                        System.out.println("Receipt generated:");
                        System.out.println(receipt);
                    } else {
                        System.out.println("Invalid ticket number. Cannot generate receipt.");
                    }
                } else {
                    System.out.println("Unparking failed. Slot may be empty or invalid.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
