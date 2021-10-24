package com.restcountries.demo.storage;

import com.restcountries.demo.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CountryStorage {
    @Autowired
    private RestTemplate restTemplate;
    private static final String url = "https://restcountries.com/v2/regionalbloc/eu?fields=name,capital,currencies,population,area";

    public List<Country> getCountries() {
        Country[] countries = restTemplate.getForObject(url, Country[].class);
        List<Country> countryList = Arrays.asList(countries);
        return countryList;
    }

    public List<Country> getCountriesTop10Area() {
        var countries = getCountries();
        Collections.sort(countries, Comparator.comparing(Country::getArea).reversed());
        return countries.subList(0,10);
    }

    public List<Country> getCountriesTop10Population() {
        var countries = getCountries();
        Collections.sort(countries, Comparator.comparing(Country::getPopulation).reversed());
        return countries.subList(0,10);
    }

    public List<Country> getCountriesTop10Density() {
        var countries = getCountries();
        Collections.sort(countries, Comparator.comparing(Country::getDensity).reversed());
        return countries.subList(0,10);
    }
}
