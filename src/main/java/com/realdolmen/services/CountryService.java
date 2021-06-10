package com.realdolmen.services;

import com.realdolmen.repositories.CountryRepository;
import com.realdolmen.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository ;

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
