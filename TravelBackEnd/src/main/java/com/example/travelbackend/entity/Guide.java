package com.example.travelbackend.entity;
import javax.persistence.Entity;

@Entity
public class Guide extends User {

    private String phoneNumber;

    public Guide() {
        super();
    }

    public Guide(Long userId, String firstName, String lastName, String email, String password, Role role, Address address, String phoneNumber) {
        super(userId, firstName, lastName, email, password, role, address);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
