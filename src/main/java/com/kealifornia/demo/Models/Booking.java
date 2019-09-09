package com.kealifornia.demo.Models;

import java.time.LocalDate;

public class Booking {

    private int id;
    private LocalDate bookStart;
    private LocalDate bookEnd;
    private int roomId;
    private int customerId;

    public Booking(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBookStart() {
        return bookStart;
    }

    public void setBookStart(LocalDate bookStart) {
        this.bookStart = bookStart;
    }

    public LocalDate getBookEnd() {
        return bookEnd;
    }

    public void setBookEnd(LocalDate bookEnd) {
        this.bookEnd = bookEnd;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Booking(int id, LocalDate bookStart, LocalDate bookEnd, int roomId, int customerId) {
        this.id = id;
        this.bookStart = bookStart;
        this.bookEnd = bookEnd;
        this.roomId = roomId;
        this.customerId = customerId;
    }
}

