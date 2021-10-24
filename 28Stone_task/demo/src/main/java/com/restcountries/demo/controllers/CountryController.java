package com.restcountries.demo.controllers;

import com.restcountries.demo.models.Country;
import com.restcountries.demo.storage.CountryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eu")
public class CountryController {
    private final CountryStorage countryStorage;

    @Autowired
    public CountryController(CountryStorage countryStorage) {
        this.countryStorage = countryStorage;
    }

    @GetMapping
    public List<Country> getCountries() {
        return this.countryStorage.getCountries();
    }

    @GetMapping("/area")
    public List<Country> get10CountriesWithBiggestArea() {
        return this.countryStorage.getCountriesTop10Area();
    }

    @GetMapping("/population")
    public List<Country> get10CountriesWithBiggestPopulation() {
        return this.countryStorage.getCountriesTop10Population();
    }

    @GetMapping("/density")
    public List<Country> get10CountriesWithBiggestDensity() {
        return this.countryStorage.getCountriesTop10Density();
    }
}
