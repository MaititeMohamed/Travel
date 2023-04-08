package com.example.travelbackend.service;

import com.example.travelbackend.entity.User;
import com.example.travelbackend.repository.RoleRepository;
import com.example.travelbackend.repository.UserRepository;
import com.example.travelbackend.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    UserRepository  userRepository;
    @Autowired
    RoleRepository roleRepository;
    //security
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findUserByEmail(email);
        System.out.println(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRoleName())));

    }
//    public User saveUser(User user){
//        user.setPassword(NoOpPasswordEncoder.getInstance().encode(user.getPassword()));
//        return userRepository.save(user);
//    }

    public  User getUserByEmail(String email){
        return  userRepository.findUserByEmail(email);
    }
}
