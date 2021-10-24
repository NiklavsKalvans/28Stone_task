package com.restcountries.demo;

import com.restcountries.demo.models.Country;
import com.restcountries.demo.storage.CountryStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CountryStorageTests {
    @Autowired
    private CountryStorage countryStorage;

    @Test
    public void getCountriesTest() {
        List<Country> result = this.countryStorage.getCountries();
        assertThat(result.size()).isEqualTo(31);
    }

    @Test
    public void getCountriesTop10AreaTest() {
        List<Country> result = this.countryStorage.getCountriesTop10Area();
        assertThat(result.size()).isEqualTo(10);
    }

    @Test
    public void getCountriesTop10PopulationTest() {
        List<Country> result = this.countryStorage.getCountriesTop10Population();
        assertThat(result.size()).isEqualTo(10);
    }

    @Test
    public void getCountriesTop10DensityTest() {
        List<Country> result = this.countryStorage.getCountriesTop10Density();
        assertThat(result.size()).isEqualTo(10);
    }
}
