package com.kealifornia.demo;


import com.kealifornia.demo.Models.Booking;
import com.kealifornia.demo.Models.Room;

import java.time.LocalDate;
import java.util.List;

public class CheckDate {

    public static int CheckDate(LocalDate checkIn, LocalDate checkOut, List<Booking> bookingList, List<Room> roomList){

        boolean ok=true;

        for(Room room : roomList){
            for(Booking book : bookingList){
                if(book.getRoomId()==room.getId()) {
                    if((checkIn.isBefore(book.getBookStart())&& checkOut.isBefore(book.getBookStart())) || (checkIn.isAfter(book.getBookEnd()) && checkOut.isAfter(book.getBookEnd())))
                        return room.getId();
                    ok=false;
                }
            }
        }
        if(ok)
            return 1;
        return -1;
    }
}
