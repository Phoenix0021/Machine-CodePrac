package com.hotelmanagementsystem.model;

import java.util.List;

public class Guest extends User{

     private List<Booking> bookings;

    public Guest(String userId, String name, String email, List<Booking> bookings){
        super(userId,name,email);
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    // Optionally: Add method to add a single booking
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }


}
