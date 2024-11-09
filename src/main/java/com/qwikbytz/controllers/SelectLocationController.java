package com.qwikbytz.controllers;

import com.qwikbytz.models.AddLocationModel;
import com.qwikbytz.repositories.AddLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// This is a Spring Boot controller that handles HTTP requests related to locations
@RestController
public class SelectLocationController {

    // Autowired allows Spring to automatically inject an instance of AddLocationRepository into this controller
    @Autowired
    private AddLocationRepository addLocationRepository;

    // This endpoint returns a list of all countries from the database
    @GetMapping("/selectlocation/country")
    public ResponseEntity<List<String>> getAllCountries() {
        // Fetch all locations from the repository, map them to their 'country' field,
        // remove duplicates (distinct), and collect them into a list
        List<String> countries = addLocationRepository.findAll().stream()
                .map(AddLocationModel::getCountry) // Get the country from each location
                .distinct()  // Remove duplicate country names
                .collect(Collectors.toList()); // Collect the results into a list

        // If the list is empty, return HTTP 204 (No Content)
        if (countries.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Return HTTP 200 (OK) along with the list of countries
        return ResponseEntity.ok(countries);
    }

    // This endpoint returns a list of states based on the country passed as a parameter
    @GetMapping("/selectlocation/state")
    public ResponseEntity<List<String>> getStatesByCountry(@RequestParam String country) {
        // Fetch all locations with the given country, map them to their 'state' field,
        // remove duplicates (distinct), and collect them into a list
        List<String> states = addLocationRepository.findByCountry(country).stream()
                .map(AddLocationModel::getState)
                .distinct()
                .collect(Collectors.toList());

        // If the list is empty, return HTTP 204 (No Content)
        if (states.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Return HTTP 200 (OK) along with the list of states
        return ResponseEntity.ok(states);
    }

    // This endpoint returns a list of cities based on the state passed as a parameter
    @GetMapping("/selectlocation/city")
    public ResponseEntity<List<String>> getCitiesByState(@RequestParam String state) {
        // Fetch all locations with the given state, map them to their 'city' field,
        // remove duplicates (distinct), and collect them into a list
        List<String> cities = addLocationRepository.findByState(state).stream()
                .map(AddLocationModel::getCity)
                .distinct()
                .collect(Collectors.toList());

        // If the list is empty, return HTTP 204 (No Content)
        if (cities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Return HTTP 200 (OK) along with the list of cities
        return ResponseEntity.ok(cities);
    }

    // This endpoint returns a list of branches based on the city passed as a parameter
    @GetMapping("/selectlocation/branch")
    public ResponseEntity<List<String>> getBranchesByCity(@RequestParam String city) {
        // Fetch all locations with the given city, map them to their 'branch' field,
        // remove duplicates (distinct), and collect them into a list
        List<String> branches = addLocationRepository.findByCity(city).stream()
                .map(AddLocationModel::getBranch)
                .distinct()
                .collect(Collectors.toList());

        // If the list is empty, return HTTP 204 (No Content)
        if (branches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Return HTTP 200 (OK) along with the list of branches
        return ResponseEntity.ok(branches);
    }

    // This endpoint accepts a POST request to submit a new location
    @PostMapping("/submit")
    public String submitLocation(@RequestBody AddLocationModel location) {
        // For now, we just print the received location object to the console
        System.out.println("Received location: " + location);

        // Return a success message
        return "Location submitted successfully!";
    }
}
