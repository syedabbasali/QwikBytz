package com.qwikbytz.controllers;

import com.qwikbytz.models.AddLocationModel;
import com.qwikbytz.repositories.AddLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddLocationController {

    private final AddLocationRepository addLocationRepository;

    @Autowired
    public AddLocationController(AddLocationRepository addLocationRepository) {
        this.addLocationRepository = addLocationRepository;
    }

    @PostMapping("/addlocation")
    public ResponseEntity<String> insert(@RequestBody AddLocationModel addLocation) {
        try {
            addLocationRepository.save(addLocation);
            return ResponseEntity.ok("Data Inserted");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to insert data");
        }
    }
}
