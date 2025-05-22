package com.hotelmanagementsystem.services;

import com.hotelmanagementsystem.model.*;
import com.hotelmanagementsystem.enums.BookingStatus;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReceptionistService {

    /**
     * Create a new booking
     */
    public Booking createBooking(Guest guest, HotelRoom room, Date checkIn, Date checkOut) {
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(
                bookingId,
                checkIn,
                checkOut,
                BookingStatus.CONFIRMED,
                null, // payment will be handled later
                null, // room services to be added later
                guest,
                room
        );
        // You may also want to update room status here
        room.setRoomStatus(com.hotelmanagementsystem.enums.RoomStatus.BOOKED);
        return booking;
    }

    /**
     * Cancel an existing booking
     */
    public void cancelBooking(Booking booking) {
        booking.setBookingStatus(BookingStatus.CANCELLED);
        booking.getRoom().setRoomStatus(com.hotelmanagementsystem.enums.RoomStatus.AVAILABLE);
    }

    /**
     * Check-in guest
     */
    public boolean checkIn(Booking booking) {
        try {
            booking.getRoom().setRoomStatus(com.hotelmanagementsystem.enums.RoomStatus.BOOKED);
        } catch (Exception e) {
           return false;
        }
         
         return true;
    }

    /**
     * Check-out guest
     */
    public boolean checkOut(Booking booking) {
        try{
        booking.setBookingStatus(BookingStatus.COMPLETED);
        booking.getRoom().setRoomStatus(com.hotelmanagementsystem.enums.RoomStatus.AVAILABLE);
    }
    catch (Exception e){
        return false;
    }
    return true;
    }

    /**
     * Add room service to a booking
     */
    public void addRoomService(Booking booking, RoomService service) {
        List<RoomService> services = booking.getRoomServices();
        if (services == null) {
            services = new java.util.ArrayList<>();
            booking.setRoomServices(services);
        }
        services.add(service);
    }
}
