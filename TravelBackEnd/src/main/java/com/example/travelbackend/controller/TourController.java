package com.example.travelbackend.controller;

import com.example.travelbackend.entity.Tour;
import com.example.travelbackend.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/getTourById/{id}")
    public Optional<Tour> getTourById(@PathVariable("id") Long id) {
        return tourService.getTourById(id);
    }

    @GetMapping("/getAllTours")
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @PostMapping("/addTour")
    public Tour addTour(@RequestBody Tour tour) {
        tourService.saveTour(tour);
        return tour;
    }

    @DeleteMapping("/deleteTourById/{id}")
    public Integer deleteTourById(@PathVariable("id") Long id) {
        return tourService.deleteTourById(id);
    }

    @PutMapping("/updateTour")
    public Tour updateTour(@RequestBody Tour tour) {
        return tourService.updateTour(tour);
    }


}


