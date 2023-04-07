package com.example.travelbackend.repository;

import com.example.travelbackend.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {


    Optional<Guide> findGuideByEmail(String email);
}

