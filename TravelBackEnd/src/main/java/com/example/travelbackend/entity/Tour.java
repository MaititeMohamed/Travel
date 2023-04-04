package com.example.travelbackend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTour;

    private String tourName;

    private String tourDescription;

    private Date startDate;

    private Date endDate;

    @ManyToOne
    private Guide guide;

    @ManyToMany
    @JoinTable(
            name = "tour_client",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Set<Client> clients = new HashSet<>();

    public Tour() {
    }

    public Tour(String tourName, String tourDescription, Date startDate, Date endDate) {
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getIdTour() {
        return idTour;
    }

    public void setIdTour(Long idTour) {
        this.idTour = idTour;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "idTour=" + idTour +
                ", tourName='" + tourName + '\'' +
                ", tourDescription='" + tourDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", clients=" + clients +
                '}';
    }
}
