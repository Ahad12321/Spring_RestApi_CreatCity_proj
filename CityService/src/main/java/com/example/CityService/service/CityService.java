package com.example.CityService.service;

import com.example.CityService.exception.CityAlreadyExsistException;
import com.example.CityService.exception.CityNotFoundException;
import com.example.CityService.model.City;
import com.example.CityService.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public  City createCity(City newCIty) {

        Optional <City>cityByName=cityRepository.findByName(newCIty.getName());
        if (cityByName.isPresent()){
            throw new CityAlreadyExsistException("City already exsist with name"+newCIty.getName());
        }

        return cityRepository.save(newCIty);
    }

    public  List<City> getAll(String name){
        if (name==null) {
            return cityRepository.findAll();
        }else {
            return cityRepository.findAllByName(name);
        }


    };

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
       return cityRepository.findById(id).orElseThrow(()->new CityNotFoundException("City not found with id"+id));
    }

    public void udateCity(String id, City newCity) {
       City oldCity= getCityById(id);
       oldCity.setName(newCity.getName());
       cityRepository.save(oldCity);
    }

}
