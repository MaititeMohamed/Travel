package com.example.travelbackend.service;


import com.example.travelbackend.entity.Client;
import com.example.travelbackend.entity.Reservation;
import com.example.travelbackend.entity.Tour;
import com.example.travelbackend.repository.ClientRepository;
import com.example.travelbackend.repository.ReservationRepository;
import com.example.travelbackend.repository.RoleRepository;
import com.example.travelbackend.repository.TourRepository;
import com.example.travelbackend.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRepository roleRepository;
     @Autowired
     private TourRepository tourRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    // Existing methods for Client CRUD operations

    public Optional<Reservation> getReservationById(Long id){
        return reservationRepository.findById(id);
    }

    public List<Reservation> getAllReservations(){return reservationRepository.findAll();}

    public Reservation saveReservation(Reservation reservation) {
        // Check if client exists
        Optional<Client> clientOptional = clientRepository.findById(reservation.getClient().getUserId());
        if (!clientOptional.isPresent()) {
            Message message = new Message();
            message.setState("Error");
            message.setMessage("Client not found");
            reservation.setClient(null);
            reservation.setMessage(message);
            return reservation;
        }

        // Check if tour exists
        Optional<Tour> tourOptional = tourRepository.findById(reservation.getTour().getId());
        if (!tourOptional.isPresent()) {
            Message message = new Message();
            message.setState("Error");
            message.setMessage("Tour not found");
            reservation.setTour(null);
            reservation.setMessage(message);
            return reservation;
        }

        // Save reservation
        reservationRepository.save(reservation);

        Message message = new Message();
        message.setState("Success");
        message.setMessage("Reservation has been created");
        reservation.setMessage(message);
        return reservation;
    }

    public Integer deleteReservationById(Long id){
        boolean exists = reservationRepository.existsById(id);
        if(!exists){
            return  -1;
        }else {
            try {
                reservationRepository.deleteById(id);
                return 1;
            } catch (Exception e){
                return 0;
            }
        }
    }

    public Reservation updateReservation(Reservation reservation) {
        // Check if reservation exists
        Optional<Reservation> existingReservationOptional = reservationRepository.findById(reservation.getId());
        if (!existingReservationOptional.isPresent()) {
            Message message = new Message();
            message.setState("Error");
            message.setMessage("Reservation not found");
            reservation.setMessage(message);
            return reservation;
        }

        // Check if client exists
        Optional<Client> clientOptional = clientRepository.findById(reservation.getClient().getUserId());
        if (!clientOptional.isPresent()) {
            Message message = new Message();
            message.setState("Error");
            message.setMessage("Client not found");
            reservation.setClient(null);
            reservation.setMessage(message);
            return reservation;
        }

        // Check if tour exists
        Optional<Tour> tourOptional = tourRepository.findById(reservation.getTour().getId());
        if (!tourOptional.isPresent()) {
            Message message = new Message();
            message.setState("Error");
            message.setMessage("Tour not found");
            reservation.setTour(null);
            reservation.setMessage(message);
            return reservation;
        }

        // Update reservation information
        Reservation existingReservation = existingReservationOptional.get();
        existingReservation.setClient(reservation.getClient());
        existingReservation.setTour(reservation.getTour());
        reservationRepository.save(existingReservation);

        Message message = new Message();
        message.setState("Success");
        message.setMessage("Reservation information updated");
        reservation.setMessage(message);
        return reservation;
    }
}
