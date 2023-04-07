package com.example.travelbackend.service;

import com.example.travelbackend.entity.Guide;
import com.example.travelbackend.repository.GuideRepository;
import com.example.travelbackend.repository.RoleRepository;
import com.example.travelbackend.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideService {

    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Guide> getGuideById(Long id){
        return guideRepository.findById(id);
    }

    public List<Guide> getAllGuides(){return  guideRepository.findAll();}

    public Optional<Guide> getGuideByEmail(String email){
        return guideRepository.findGuideByEmail(email);
    }

    public Guide saveGuide(Guide guide) {
        Message message = new Message();
        Optional<Guide> guideOptional = guideRepository.findGuideByEmail(guide.getEmail());

        if (guide.getAddress() == null || guide.getEmail() == null || guide.getPassword() == null ||
                guide.getFirstName() == null || guide.getLastName() == null || guide.getPhoneNumber() == null) {
            message.setState("Error");
            message.setMessage("Please fill in all required fields");
            guide.setMessage(message);
            return guide;
        }

        if (guideOptional.isPresent()) {
            message.setState("Error");
            message.setMessage("Email already exists");
            guide.setMessage(message);
            return guide;
        }

        message.setState("Success");
        message.setMessage("Guide has been created");
        guide.setMessage(message);
        guide.setRole(roleRepository.getRoleByRoleName("Guide"));
        guideRepository.save(guide);
        return guide;
    }

    public Integer deleteGuideById(Long id){
        boolean exists =guideRepository.existsById(id);
        if(!exists){
            return  -1;
        }else {

            try {
                guideRepository.deleteById(id);
                return 1;
            } catch (Exception e){
                return 0;
            }
        }
    }

    public Guide updateGuide(Guide guide) {
        Message message = new Message();

        // check if guide exists
        Optional<Guide> guideOptional = guideRepository.findGuideByEmail(guide.getEmail());
        if (!guideOptional.isPresent()) {
            message.setState("Error");
            message.setMessage("Guide not found");
            guide.setMessage(message);
            return guide;
        }

        // check if required fields are not null
        if (guide.getAddress() == null || guide.getEmail() == null || guide.getFirstName() == null ||
                guide.getLastName() == null || guide.getPassword() == null ||guide.getPhoneNumber()==null  ||guide.getFirstName().isEmpty()
                ||guide.getAddress().isEmpty() ||guide.getEmail().isEmpty() ||guide.getLastName().isEmpty()
                ||guide.getPassword().isEmpty()  ||guide.getPhoneNumber().isEmpty()
        ) {
            message.setState("Error");
            message.setMessage("Please fill in all required fields");
            guide.setMessage(message);
            return guide;
        }

        // check if email is not already taken by another guide
        Optional<Guide> existingGuideOptional = guideRepository.findGuideByEmail(guide.getEmail());
        if (existingGuideOptional.isPresent() && !existingGuideOptional.get().getUserId().equals(guideOptional.get().getUserId())) {
            message.setState("Error");
            message.setMessage("Email is already taken");
            guide.setMessage(message);
            return guide;
        }

        // update guide information
        Guide existingGuide = guideOptional.get();
        existingGuide.setAddress(guide.getAddress());
        existingGuide.setEmail(guide.getEmail());
        existingGuide.setPhoneNumber(guide.getPhoneNumber());
        existingGuide.setFirstName(guide.getFirstName());
        existingGuide.setLastName(guide.getLastName());
        existingGuide.setPassword(guide.getPassword());
        guideRepository.save(existingGuide);

        message.setState("Success");
        message.setMessage("Guide information updated");
        guide.setMessage(message);
        return guide;
    }

}