package com.qwikbytz.controllers;

import com.qwikbytz.models.AddLocationModel;
import com.qwikbytz.repositories.AddLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SelectLocationController {

    @Autowired
    private AddLocationRepository addLocationRepository;

    @GetMapping("/selectlocation/country")
    public ResponseEntity<List<String>> getAllCountries() {
        List<String> countries = addLocationRepository.findAll().stream()
                .map(AddLocationModel::getCountry)
                .distinct()
                .collect(Collectors.toList());

        if (countries.isEmpty()) {
            return ResponseEntity.noContent().build();  // HTTP 204
        }

        return ResponseEntity.ok(countries);  // HTTP 200 Error
    }

    @GetMapping("/selectlocation/state")
    public ResponseEntity<List<String>> getStatesByCountry(@RequestParam String country) {
        List<String> states = addLocationRepository.findByCountry(country).stream()
                .map(AddLocationModel::getState)
                .distinct()
                .collect(Collectors.toList());

        if (states.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(states);
    }

    @GetMapping("/selectlocation/city")
    public ResponseEntity<List<String>> getCitiesByState(@RequestParam String state) {
        List<String> cities = addLocationRepository.findByState(state).stream()
                .map(AddLocationModel::getCity)
                .distinct()
                .collect(Collectors.toList());

        if (cities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cities);
    }

    @GetMapping("/selectlocation/branch")
    public ResponseEntity<List<String>> getBranchesByCity(@RequestParam String city) {
        List<String> branches = addLocationRepository.findByCity(city).stream()
                .map(AddLocationModel::getBranch)
                .distinct()
                .collect(Collectors.toList());

        if (branches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(branches);
    }
    @PostMapping("/submit")
    public String submitLocation(@RequestBody AddLocationModel location) {
        // For now, just print the location to the console (or save it to a database)
        System.out.println("Received location: " + location);

        // Return a simple success message
        return "Location submitted successfully!";
    }
}
