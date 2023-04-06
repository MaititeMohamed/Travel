package com.example.travelbackend.config;


import com.example.travelbackend.entity.Role;
import com.example.travelbackend.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfig {
    @Bean
    CommandLineRunner commandLineRunner (RoleRepository roleRepository){
        return args -> {
            Role role1 = new Role(1L,"Admin");
            Role role2 = new Role(2L,"Client");
            Role role3 = new Role(3L,"Guide");
            roleRepository.saveAll(List.of(role1,role2,role3));
        };
    }
}

