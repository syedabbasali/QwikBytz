//package com.qwikbytz.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.persistence.Column;
//
//@Entity
//@Table(name = "select_location")  // Optional: Define custom table name
//public class SelectLocationModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID
//    private Long id;
//
//    @Column(name = "state", nullable = false)
//    private String state;
//
//    @Column(name = "city", nullable = false)
//    private String city;
//
//    @Column(name = "branch", nullable = false)
//    private String branch;
//
//    // Empty constructor
//    public SelectLocationModel() {
//    }
//
//    public SelectLocationModel(String state, String city, String branch) {
//        this.state = state;
//        this.city = city;
//        this.branch = branch;
//    }
//
//
//
//    // Getters and Setters
//    public String getState() { return state; }
//    public void setState(String state) { this.state = state; }
//
//    public String getCity() { return city; }
//    public void setCity(String city) { this.city = city; }
//
//    public String getBranch() { return branch; }
//    public void setBranch(String branch) { this.branch = branch; }
//}
