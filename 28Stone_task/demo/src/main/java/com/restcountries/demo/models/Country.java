package com.restcountries.demo.models;

import java.util.List;

public class Country {
    public String name;
    public String capital;
    public List<Currency> currencies;
    public int population;
    public double area;

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public double getDensity() {
        if (area < 1)
            return population;
        return Math.round(population/area);
    }
}
