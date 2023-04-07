package com.example.travelbackend.entity;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Guide extends User {

    private String phoneNumber;

    @OneToMany(mappedBy = "guide")
    private Set<Tour> tours;
    public Guide() {
        super();
    }


    public Guide(Long userId, String firstName, String lastName, String email, String password, Role role, String address, String phoneNumber) {
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
        return "Guide{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", tours=" + tours +
                '}';
    }
}
