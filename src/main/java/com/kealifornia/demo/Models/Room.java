package com.kealifornia.demo.Models;

public class Room {

    public Room(int id, int roomNum, int roomTypeId) {
        this.id = id;
        this.roomNum = roomNum;
        this.roomTypeId = roomTypeId;
    }

    public Room(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    private int id;
    private int roomNum;
    private int roomTypeId;
}

