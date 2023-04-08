package com.example.travelbackend.controller;

import com.example.travelbackend.entity.Reservation;
import com.example.travelbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getReservationById/{id}")
    public Optional<Reservation> getReservationById(@PathVariable("id") Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
        return reservation;
    }

    @DeleteMapping("/deleteReservationById/{id}")
    public Integer deleteReservationById(@PathVariable("id") Long id) {
        return reservationService.deleteReservationById(id);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }
}
