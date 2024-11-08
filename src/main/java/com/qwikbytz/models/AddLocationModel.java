package com.qwikbytz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "add_location")  // Custom table name (optional)
public class AddLocationModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID
        private Long id;

        @Column(name = "Country", nullable = false)
        private String country;

        @Column(name = "State", nullable = false)
        private String state ;

        @Column(name = "City", nullable = false)
        private String city;

        @Column(name = "Branch", nullable = false)
        private String branch;

    public AddLocationModel() {
    }

    public AddLocationModel(String country, String state, String city, String branch) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
