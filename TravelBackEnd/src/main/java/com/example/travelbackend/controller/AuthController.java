package com.example.travelbackend.controller;




import com.example.travelbackend.entity.User;
import com.example.travelbackend.security.JwtUtils;
import com.example.travelbackend.service.UserService;
import com.example.travelbackend.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin("http://localhost:4200")
public class AuthController {
@Autowired
AuthenticationManager authenticationManager;
@Autowired
UserService userService;
@Autowired
JwtUtils jwtUtils;


@PostMapping("/login")
    public ResponseEntity<Object> auth(@RequestBody User request){
    //check if user authenticate (true )
    //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
     //get from DB
     UserDetails user = userService.loadUserByUsername(request.getEmail());

     if (user != null){
         return ResponseEntity.ok(new ResponseDTO("success","token",jwtUtils.generateToken(user)));
     }
     return ResponseEntity.status(400).body("error");
    }
}

