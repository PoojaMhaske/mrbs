package com.digitas.bookingservice.controller;

import com.digitas.bookingservice.model.Booking;
import com.digitas.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    BookingRepository bookingRepo;

    // Get All Bookings
    @GetMapping("/list")
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    // Create a new booking
    @PostMapping("/add")
    public Booking createBooking(@Valid @RequestBody Booking booking) {

        return bookingRepo.save(booking);
    }

    //Find booking by id
    @GetMapping("/find/{id}")
    public Booking getBookingById(@PathVariable(value = "id") Long BookingId) {
        return bookingRepo.findByid(BookingId);
    }

    //delete booking by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable(value = "id") Long BookingId) {
        Booking booking = bookingRepo.findByid(BookingId);

        bookingRepo.delete(booking);

        return ResponseEntity.ok().build();
    }


  //update booking by id
    @PutMapping("/update/{id}")
    public Booking updateBooking(@PathVariable(value = "id") Long BookingId,
                                 @Valid @RequestBody Booking bookingDetails) {

        Booking booking =bookingRepo.findByid(BookingId);

        booking.setType(bookingDetails.getType());

        booking.setDate(bookingDetails.getDate());

        Booking updatedBookig = bookingRepo.save(booking);
        return updatedBookig;
    }


}

