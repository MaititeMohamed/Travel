package com.example.travelbackend.controller;

import com.example.travelbackend.entity.Guide;
import com.example.travelbackend.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guides")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @GetMapping("/getGuideById/{id}")
    public Optional<Guide> getGuideById(@PathVariable("id") Long id){
        return guideService.getGuideById(id);
    }

    @GetMapping("/getAllGuides")
    public List<Guide> getAllGuides(){
        return guideService.getAllGuides();
    }

    @PostMapping("/addGuide")
    public Guide addGuide(@RequestBody Guide guide){
        return guideService.saveGuide(guide);
    }

    @DeleteMapping("/deleteGuideById/{id}")
    public Integer deleteGuideById(@PathVariable("id") Long id){
        return guideService.deleteGuideById(id);
    }

    @PutMapping("/updateGuide")
    public  Guide updateGuide(@RequestBody Guide guide){
        return guideService.updateGuide(guide);
    }
}


