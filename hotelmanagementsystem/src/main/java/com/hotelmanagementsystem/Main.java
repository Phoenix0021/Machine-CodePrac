package com.hotelmanagementsystem;

import com.hotelmanagementsystem.model.*;
import com.hotelmanagementsystem.enums.*;
import com.hotelmanagementsystem.services.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();
        HouseKeepingLogService houseKeepingLogService = new HouseKeepingLogService();
        ReceptionistService receptionistService = new ReceptionistService();

        Map<Integer, HotelRoom> hotelRooms = new HashMap<>();

        while(true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add Room");
            System.out.println("2. Check-out Booking");
            System.out.println("3. Log Housekeeping Task");
            System.out.println("4. Show Housekeeping Logs by Room");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Select Room Type:");
                    RoomType[] roomTypes = RoomType.values();
                    for (int i=0; i < roomTypes.length; i++) {
                        System.out.println((i+1) + ". " + roomTypes[i]);
                    }
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();

                    RoomType roomType = roomTypes[typeChoice - 1];

                    System.out.println("Select Room Status:");
                    RoomStatus[] roomStatuses = RoomStatus.values();
                    for (int i=0; i < roomStatuses.length; i++) {
                        System.out.println((i+1) + ". " + roomStatuses[i]);
                    }
                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    RoomStatus roomStatus = roomStatuses[statusChoice - 1];

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    HotelRoom room = new HotelRoom(roomNumber, roomType, roomStatus, price);
                    hotelRooms.put(roomNumber, room);
                    System.out.println("Room added successfully.");
                    break;

                case 2:
                    System.out.print("Enter booking ID to check-out: ");
                    String bookingId = scanner.nextLine();
                    Booking booking = bookingService.getBookingById(bookingId);
                    if (booking == null) {
                        System.out.println("Booking not found!");
                        break;
                    }
                    boolean success = receptionistService.checkOut(booking);
                    if(success) {
                        System.out.println("Check-out completed.");
                    } else {
                        System.out.println("Check-out failed. Booking might not be checked in.");
                    }
                    break;

                case 3:
                    System.out.print("Enter room number for housekeeping log: ");
                    int logRoomNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter housekeeping task description: ");
                    String taskDesc = scanner.nextLine();

                    // Assuming HouseKeepingLog has a constructor: HouseKeepingLog(int roomNumber, String description, Date date)
                    System.out.println("Housekeeping task logged.");
                    break;

                case 4:
                    System.out.print("Enter room number to view housekeeping logs: ");
                    int logsRoomNumber = scanner.nextInt();
                    scanner.nextLine();

                    List<HouseKeepingLog> logs = houseKeepingLogService.logTasksByRoom(logsRoomNumber);
                    if (logs == null || logs.isEmpty()) {
                        System.out.println("No logs found for this room.");
                    } else {
                        System.out.println("Housekeeping Logs:");
                        for (HouseKeepingLog log1 : logs) {
                            System.out.println("- " + log1);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
