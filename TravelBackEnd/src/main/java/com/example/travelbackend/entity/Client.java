package com.example.travelbackend.entity;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Client extends User {

    private String phoneNumber;

    @ManyToMany(mappedBy = "clients")
    private Set<Client> clients;
    public Client() {
    }

    public Client(Long userId, String firstName, String lastName, String email, String password, Role role, Address address, String phoneNumber) {
        super(userId, firstName, lastName, email, password, role, address);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", userId=" + getUserId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role=" + getRole() +
                ", address=" + getAddress() +
                '}';
    }
}