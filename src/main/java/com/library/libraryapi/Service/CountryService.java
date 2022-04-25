package com.library.libraryapi.Service;

import com.library.libraryapi.Entity.Country;
import com.library.libraryapi.Repository.CountryRepository;
import com.library.libraryapi.Request.CountryRequest;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void addCountry(CountryRequest countryRequest) {
        Country country=new Country();
        country.setContinent(countryRequest.getContinent());
        country.setName(countryRequest.getName());
        countryRepository.save(country);
    }
}
