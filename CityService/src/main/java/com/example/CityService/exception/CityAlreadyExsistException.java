package com.example.CityService.exception;

public class CityAlreadyExsistException extends RuntimeException {
    public CityAlreadyExsistException(String msg) {
        super(msg);
    }
}
