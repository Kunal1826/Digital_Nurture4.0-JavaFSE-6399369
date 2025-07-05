package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {


    @Autowired
    CountryRepository repo;

    //Mendatory handson feature

    @Transactional
    public List<Country> getAllCountries(){
        return repo.findAll();
    }

    //additional handson feature

    @Transactional
    public Country findCountryByCode(String countrycode) throws CountryNotFoundException{
        Optional<Country> result =  repo.findById(countrycode);

        if(!result.isPresent()){
            throw new CountryNotFoundException("Country with code " + countrycode + " not found");
        }

        return result.get();

    }

     @Transactional
    public void addCountry(Country country){
        repo.save(country);

     }

    @Transactional
    public Country updateCountry(String id, String name) throws CountryNotFoundException {
         Country country = repo.findById(id).orElseThrow(() -> new CountryNotFoundException("Not found"));
         country.setName(name);
         repo.save(country);
         return repo.findById(id).orElseThrow(() -> new CountryNotFoundException("Not found"));
    }

     @Transactional
    public void deleteCountry(String id){
        repo.deleteById(id);
        Optional<Country> c = repo.findById(id);
        if(!c.isPresent()){
            System.out.println("Country is deleted");
        }else{
            System.out.println("Country not deleted");
        }
    }


}
