package com.travel.travelwebsite.controller;

import com.travel.travelwebsite.entity.Booking;
import com.travel.travelwebsite.repository.BookingRepository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/packages")
    public String packages() {
        return "packages";
    }

 @GetMapping("/contact")
public String contact(@RequestParam(required = false) String place, Model model) {
        model.addAttribute("selectedPlace", place);
        return "contact";
    }


@PostMapping("/submitBooking")
public String submitBooking(
        @RequestParam String name,
        @RequestParam String phone,
        @RequestParam String email,
        @RequestParam String travelDate,
        @RequestParam int persons,
        @RequestParam String destination,
        @RequestParam String message,
        Model model) {

    Booking booking = new Booking();
    booking.setName(name);
    booking.setPhone(phone);
    booking.setEmail(email);
    booking.setTravelDate(LocalDate.parse(travelDate));
    booking.setPersons(persons);
    booking.setDestination(destination);
    booking.setMessage(message);

    bookingRepository.save(booking);

    model.addAttribute("successMessage", "Message sent to Travel Explorer successfully!");
    return "contact";
}


}

