package com.example.travelbackend.repository;

import com.example.travelbackend.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {


    Tour findByName(String name);
}

