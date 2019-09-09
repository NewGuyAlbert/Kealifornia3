package com.kealifornia.demo;

import com.kealifornia.demo.Models.Customer;
import com.kealifornia.demo.Models.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller

public class HomeController {

    @Autowired
    private Repo repo;

    @GetMapping("/")
    public String index(Model model){
        List<RoomType> roomTypeList = repo.findAllRoomTypes();
        model.addAttribute("roomTypes",roomTypeList);

        return "index";
    }

    @RequestMapping(value = "/room/delete/{index}")
    public String handleRoomDelete(@PathVariable int index) {
        Repo.deleteRoom(index);
        return "viewRom";
    }


    @GetMapping("/payed")
    public String payed(){
        return "payed";
    }

    @PostMapping("/saveinfo")
    public String saveInfo(@ModelAttribute Customer customer){
        repo.addInfo(customer);
        return "admin";
    }

    @PostMapping("/saveroom")
    public String saveroom(@ModelAttribute RoomType roomtype) {
        Repo.addRoom(roomtype);
        return "admin/createRoom";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("/admin/addRoom")
    public String addRoom(){
        return "admin/addRoom";
    }

    @GetMapping("/admin/editRoom")
    public String editRoom() {
        return "admin/editRoom";
    }

    @GetMapping("/admin/viewRoom")
    public String viewRoom() {
        return "admin/viewRoom";
    }

    @GetMapping("/termsANDconditions")
        public String terms() {
        return "terms";
    }

    @GetMapping("/room/{index}")
    public String room(@PathVariable int index, Model model){

        model.addAttribute("roomType",repo.findRoomType(index));
        model.addAttribute("index",index);


        return "room";
    }
    @RequestMapping("/book/{index}")
    public String date(@RequestParam String checkIn,@RequestParam String checkOut,@PathVariable int index,Model model){

        model.addAttribute("index",index);
        model.addAttribute("roomType",repo.findRoomType(index));
        model.addAttribute("customerForm", new Customer());

        int roomId=CheckDate.CheckDate(LocalDate.parse(checkIn),LocalDate.parse(checkOut),repo.findAllBooking(),repo.findAllRoomForType(index));

        model.addAttribute("book",roomId);
        return "book";
    }



}
