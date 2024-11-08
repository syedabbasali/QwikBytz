package com.qwikbytz.repositories;

import com.qwikbytz.models.AddLocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddLocationRepository extends JpaRepository<AddLocationModel, Long> {

    // Fetch locations by country
    List<AddLocationModel> findByCountry(String country);

    // Fetch locations by state
    List<AddLocationModel> findByState(String state);

    // Fetch locations by city
    List<AddLocationModel> findByCity(String city);

    List<AddLocationModel> findByBranch(String branch);

}
