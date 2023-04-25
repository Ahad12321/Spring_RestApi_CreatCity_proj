package com.example.CityService.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String msg){
        super(msg);
    }
}
