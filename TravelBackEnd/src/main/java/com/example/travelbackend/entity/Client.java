package com.example.travelbackend.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Client extends User {

    private String phoneNumber;

    @ManyToMany
    private Set<Tour> tours;

    public Client() {
    }

    public Client(Long userId, String firstName, String lastName, String email, String password, Role role, String address, String phoneNumber) {
        super(userId, firstName, lastName, email, password, role, address);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Client{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", tours=" + tours +
                '}';
    }
}
