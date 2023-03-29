package com.example.travelbackend.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(Long userId, String firstName, String lastName, String email, String password, Role role, Address address) {
        super(userId, firstName, lastName, email, password, role, address);
    }
}
