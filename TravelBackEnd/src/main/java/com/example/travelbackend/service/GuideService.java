package com.example.travelbackend.service;

import com.example.travelbackend.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuideService {

    @Autowired
    private GuideRepository guideRepository;


}
