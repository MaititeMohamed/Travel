package com.example.travelbackend.entity;

import com.example.travelbackend.util.Message;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String image;
    private String description;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    private Guide guide;

    @ManyToMany(mappedBy = "tours")
    private Set<Client> clients = new HashSet<>();

    public Tour() {
    }

    public Tour(Long id, String name, String image, String description, Date startDate, Date endDate, Guide guide, Set<Client> clients) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guide = guide;
        this.clients = clients;
    }

    public Tour(String name, String image, String description, Date startDate, Date endDate, Guide guide, Set<Client> clients) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guide = guide;
        this.clients = clients;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Transient
    private Message message;

    public Message getMessage ( ) {
        return message;
    }

    public void setMessage ( Message message ) {
        this.message = message;
    }
}
