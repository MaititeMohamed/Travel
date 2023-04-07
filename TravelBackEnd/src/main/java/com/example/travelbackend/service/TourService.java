package com.example.travelbackend.service;

import com.example.travelbackend.entity.Tour;
import com.example.travelbackend.repository.TourRepository;
import com.example.travelbackend.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;



    public Optional<Tour> getTourById(Long id) {
        return tourRepository.findById(id);
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour saveTour(Tour tour) {
        Message message = new Message();
        // Check if required fields are not null
        if (tour.getName() == null || tour.getDescription() == null || tour.getStartDate() == null ||
                tour.getEndDate() == null) {
            message.setState("Error");
            message.setMessage("Please fill in all required fields");
            tour.setMessage(message);
            return tour;
        }
        // Check if tour with the same name already exists
        Tour existingTour = tourRepository.findByName(tour.getName());
        if (existingTour != null) {
            message.setState("Error");
            message.setMessage("Tour with the same name already exists");
            tour.setMessage(message);
            return tour;
        }
        // Save the new tour
        tourRepository.save(tour);
        message.setState("Success");
        message.setMessage("Tour has been created");
        tour.setMessage(message);
        return tour;
    }


    public Integer deleteTourById(Long id) {
        boolean exists = tourRepository.existsById(id);
        if (!exists) {
            return -1;
        } else {
            try {
                tourRepository.deleteById(id);
                return 1;
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public Tour updateTour(Tour tour) {
        Message message = new Message();
        // check if tour exists
        Optional<Tour> tourOptional = tourRepository.findById(tour.getId());
        if (!tourOptional.isPresent()) {
            message.setState("Error");
            message.setMessage("Tour not found");
            tour.setMessage(message);
            return tour;
        }
        // check if required fields are not null
        if (tour.getName() == null || tour.getDescription() == null || tour.getStartDate() == null ||
                tour.getEndDate() == null || tour.getImage() == null) {
            message.setState("Error");
            message.setMessage("Please fill in all required fields");
            tour.setMessage(message);
            return tour;
        }
        // update tour information
        Tour existingTour = tourOptional.get();
        existingTour.setName(tour.getName());
        existingTour.setImage(tour.getImage());
        existingTour.setDescription(tour.getDescription());
        existingTour.setStartDate(tour.getStartDate());
        existingTour.setEndDate(tour.getEndDate());
        existingTour.setGuide(tour.getGuide());
        existingTour.setClients(tour.getClients());
        tourRepository.save(existingTour);
        message.setState("Success");
        message.setMessage("Tour information updated");
        tour.setMessage(message);
        return tour;
    }
}