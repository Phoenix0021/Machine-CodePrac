package com.hotelmanagementsystem.services;



import com.hotelmanagementsystem.model.Booking;
import com.hotelmanagementsystem.model.Guest;
import com.hotelmanagementsystem.model.HotelRoom;
import com.hotelmanagementsystem.enums.BookingStatus;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors; 

public class BookingService {

    // Simulated booking repository
    private final Map<String, Booking> bookingMap = new HashMap<>();

    /**
     * Save a new booking
     */
    public void saveBooking(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
    }

    /**
     * Get a booking by its ID
     */
    public Booking getBookingById(String bookingId) {
        return bookingMap.get(bookingId);
    }

    public void deleteBookingByRoomNumber(int roomNumber) {
    bookingMap.values().removeIf(booking -> booking.getRoom().getRoomNumber() == roomNumber);
}

    /**
     * Get all bookings for a particular guest
     */
    public List<Booking> getAllBookingsForGuest(Guest guest) {
        return bookingMap.values()
                .stream()
                .filter(b -> b.getGuest().equals(guest))
                .collect(Collectors.toList());
    }

    /**
     * Update an existing booking
     */
    public void updateBooking(String bookingId, Date newCheckIn, Date newCheckOut, HotelRoom newRoom) {
        Booking booking = bookingMap.get(bookingId);
        if (booking != null) {
            booking.setCheckInDate(newCheckIn);
            booking.setCheckOutDate(newCheckOut);
            booking.setRoom(newRoom);
        }
    }

    /**
     * Delete a booking
     */
    public void deleteBooking(String bookingId) {
        Booking booking = bookingMap.remove(bookingId);
        if (booking != null) {
            booking.getRoom().setRoomStatus(com.hotelmanagementsystem.enums.RoomStatus.AVAILABLE);
        }
    }

    /**
     * Check if a room is available for a given date range
     */
    public boolean isRoomAvailable(HotelRoom room, Date checkIn, Date checkOut) {
        for (Booking booking : bookingMap.values()) {
            if (booking.getRoom().getRoomNumber() == room.getRoomNumber()
                    && booking.getBookingStatus() != BookingStatus.CANCELLED
                    && datesOverlap(booking.getCheckInDate(), booking.getCheckOutDate(), checkIn, checkOut)) {
                return false;
            }
        }
        return true;
    }

    private boolean datesOverlap(java.util.Date existingStart, java.util.Date existingEnd, Date newStart, Date newEnd) {
        return !(newEnd.before(existingStart) || newStart.after(existingEnd));
    }
}
