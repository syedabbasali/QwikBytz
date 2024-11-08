package com.qwikbytz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "menu_item")  // Custom table name (optional)
public class MenuItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "description", nullable = false) // Allow null for description (optional)
    private String description;

    // Default constructor (required by JPA)
    public MenuItemModel() {}

    // Constructor with parameters
    public MenuItemModel(String name, String price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrice() { return price; }
    public void setPrice(String price) {this.price = price; }

    public String getCategory() {return category; }
    public void setCategory(String category) { this.category = category;}

    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description; }
}
