package com.realdolmen.services;

import com.realdolmen.repositories.CountryRepository;
import com.realdolmen.domain.Country;

import java.util.List;

public class CountryService {
    private CountryRepository countryRepository = new CountryRepository();

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
