package com.example.CityService.repository;

import com.example.CityService.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City,String> {
    List<City> findAllByName(String name);
    Optional<City>findByName(String name);

}
