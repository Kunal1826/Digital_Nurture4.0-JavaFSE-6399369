package com.cognizant.orm_learn.service;

public class CountryNotFoundException extends Throwable {
    public CountryNotFoundException(String message) {
        super(message);
    }
}
