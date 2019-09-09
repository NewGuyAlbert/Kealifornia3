package com.kealifornia.demo;

import com.kealifornia.demo.Models.Booking;
import com.kealifornia.demo.Models.Customer;
import com.kealifornia.demo.Models.Room;
import com.kealifornia.demo.Models.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Repo {

    @Autowired
    private JdbcTemplate jdbc;

//    public String test()
//    {
//        SqlRowSet rs = jdbc.queryForRowSet("select * from roomtype");
//        rs.next();
//        return rs.getString("name");
//    }

    public List<RoomType> findAllRoomTypes() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM roomtype");
        List<RoomType> roomTypeList = new ArrayList<>();

        while (rs.next()) {
            RoomType roomtype = new RoomType();
            roomtype.setId(rs.getInt("roomtypeid"));
            roomtype.setName(rs.getString("name"));
            roomtype.setDescription(rs.getString("description"));
            roomtype.setPrice(rs.getString("price"));
            roomTypeList.add(roomtype);
        }
        return roomTypeList;
    }

    public List<Room> findAllRooms() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM room");
        List<Room> roomList = new ArrayList<>();

        while (rs.next()) {
            Room room = new Room();
            room.setId(rs.getInt("roomid"));
            room.setRoomNum(rs.getInt("roomnum"));
            room.setRoomTypeId(rs.getInt("roomtypeid"));
            roomList.add(room);
        }
        return roomList;
    }

    public Room findRoom(int id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM room WHERE roomid = " + id);
        Room room = new Room();

        while (rs.next()) {
            room.setId(rs.getInt("roomid"));
            room.setRoomNum(rs.getInt("roomnum"));
            room.setRoomTypeId(rs.getInt("roomtypeid"));
        }
        return room;
    }

    public RoomType findRoomType(int id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM roomtype WHERE roomtypeid = " + id);
        RoomType roomtype = new RoomType();

        while (rs.next()) {
            roomtype.setId(rs.getInt("roomtypeid"));
            roomtype.setName(rs.getString("name"));
            roomtype.setDescription(rs.getString("description"));
            roomtype.setPrice(rs.getString("price"));
        }
        return roomtype;
    }

    public void addInfo(Customer customer) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES(null , ?,?,?)", new String[]{"id"});
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getEmail());
                ps.setString(3, customer.getPhoneNo());
                return ps;
            }
        };

       jdbc.update(psc);

    }

    public static void addRoom(RoomType roomtype) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO roomtype VALUES(null , ?,?,?,?)", new String[]{"id"});
                ps.setString(1, roomtype.getName());
                ps.setString(2, roomtype.getDescription());
                ps.setString(3, roomtype.getPrice());
                ps.setString(4, roomtype.getImage());
                return ps;
            }
        };

     //   jdbc.update(psc);

    }

    public List<Room> findAllRoomForType(int type){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM room WHERE roomtypeid = " + type);
        List<Room> roomList = new ArrayList<>();

        while(rs.next()){
            Room room = new Room();
            room.setId(rs.getInt("roomid"));
            room.setRoomNum(rs.getInt("roomnum"));
            room.setRoomTypeId(rs.getInt("roomtypeid"));
            roomList.add(room);

        }
        return roomList;
    }

    public List<Booking> findAllBooking() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking");
        List<Booking> bookingList = new ArrayList<>();


        while(rs.next()){
            Booking booking = new Booking();
            booking.setId(rs.getInt("bookingid"));
            booking.setBookStart(rs.getDate("bookstart").toLocalDate());
            booking.setBookEnd(rs.getDate("bookend").toLocalDate());
            booking.setCustomerId(rs.getInt("customerid"));
            booking.setRoomId(rs.getInt("roomid"));
            bookingList.add(booking);

        }

        return bookingList;
    }


    public static void deleteRoom(int index)
    {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM cars WHERE id =?");
                ps.setInt(1,index);
                return ps;
            }
        };



   //     jdbc.update(psc);


    }





}