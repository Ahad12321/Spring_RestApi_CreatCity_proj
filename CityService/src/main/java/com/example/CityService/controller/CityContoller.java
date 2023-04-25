package com.example.CityService.controller;

import com.example.CityService.exception.CityAlreadyExsistException;
import com.example.CityService.exception.CityNotFoundException;
import com.example.CityService.model.City;
import com.example.CityService.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityContoller {
    private final CityService cityService;


    @GetMapping
    public ResponseEntity<List<City>> getCities(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(cityService.getAll(name), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id) {

            return new ResponseEntity<>(getCityById(id), OK);


    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City newCIty) {
        return new ResponseEntity<>(cityService.createCity(newCIty), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getCity(@PathVariable String id, @RequestBody City newCity) {
        City oldCity = getCityById(id);
        oldCity.setName(newCity.getName());
        oldCity.setCreateDate(new Date());
        cityService.udateCity(id, newCity);
        return new ResponseEntity<>(OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(OK);
    }

    private City getCityById(String id) {
        return cityService.getCityById(id);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<String> handleCityNotFoundExcption(CityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);

    }

    @ExceptionHandler(CityAlreadyExsistException.class)
    public ResponseEntity<String> handleCitAlreadyExsistExcption(CityAlreadyExsistException ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);

    }

}
