1. The system should support the booking of differen types of rooms: standard, deluxe and suite.
2. Guest should be able to search the room inventory and book any available room.
3. The system should be able to retrieve information such as who booked a particular room or what rooms were booked by particular customer.
4. The system should allow the users to cancel their booking and provide them full refund if cancellation occurs 24Hrs before the check-in date.
5. The system should be able to send the notification 24Hrs before the check-in date for check-in and 1 Hr before the check-out time.
6. The system should be able to maintain housekeeping logs to keep track of all housekeeping-tasks.
7. Any customer should be able to add room service and/or food items.
8. The customer should be able to pay the bill through card/cash or online.
9. Admin should be able to add/delete a room.
10. Receiptionist should be able to check in or check out a room.




com.hotelmanagement
├── enums
│   ├── RoomType.java
│   ├── RoomStatus.java
│   ├── BookingStatus.java
│   ├── PaymentStatus.java
│   └── PaymentMode.java
│
├── models
│   ├── HotelRoom.java
│   ├── Booking.java
│   ├── Guest.java
│   ├── User.java
│   ├── Receptionist.java
│   ├── Admin.java
│   ├── Payment.java
│   ├── RoomService.java
│   └── HousekeepingLog.java
│
├── services
│   ├── BookingService.java
│   ├── NotificationService.java
│   ├── PaymentService.java
│   ├── RoomServiceManager.java
│   └── HousekeepingService.java
│
├── utils
│   └── DateUtils.java
│
└── Main.java
