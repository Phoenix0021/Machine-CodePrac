package com.hotelmanagementsystem.model;

import java.util.Date;
import java.util.List;
import com.hotelmanagementsystem.enums.BookingStatus;

public class Booking {
    private String bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private BookingStatus bookingStatus;
    private Payment payment;
    private List<RoomService> roomServices;
    private Guest guest;
    private HotelRoom room;  // or Room room, if using base class

    public Booking(String bookingId, Date checkInDate, Date checkOutDate, BookingStatus bookingStatus,
                   Payment payment, List<RoomService> roomServices, Guest guest, HotelRoom room) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingStatus = bookingStatus;
        this.payment = payment;
        this.roomServices = roomServices;
        this.guest = guest;
        this.room = room;
    }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public Date getCheckInDate() { return checkInDate; }
    public void setCheckInDate(Date checkInDate) { this.checkInDate = checkInDate; }

    public Date getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }

    public BookingStatus getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(BookingStatus bookingStatus) { this.bookingStatus = bookingStatus; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public List<RoomService> getRoomServices() { return roomServices; }
    public void setRoomServices(List<RoomService> roomServices) { this.roomServices = roomServices; }

    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }

    public HotelRoom getRoom() { return room; }
    public void setRoom(HotelRoom room) { this.room = room; }
}
