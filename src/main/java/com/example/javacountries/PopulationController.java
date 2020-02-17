package com.example.javacountries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("population")
@RestController
public class PopulationController {
    private List<Country> countries;

    public PopulationController() {
        this.countries = CountryList.countryList;
    }

//    * /population/size/{people}
//      * return the countries that have a population equal to or greater than the given population
    @GetMapping("size/{people}")
    public List<String> getAllCountriesWithSize(@PathVariable("people") int people) {
        return countries.stream()
                .filter(country -> country.getPopulation() >= people)
                .map(Country::getName)
                .sorted()
                .collect(Collectors.toList());
    }
//    * /population/min
//      * return the country with the smallest population
    @GetMapping("min")
    public Country getAllCountriesWithMinPop() {
        return countries.stream()
                .min(Comparator.comparingInt(Country::getPopulation)).get();
    }

//    * /population/max
//      * return the country with the largest population
    @GetMapping("max")
    public Country getAllCountriesWithMaxPop() {
        return countries.stream()
                .max(Comparator.comparingInt(Country::getPopulation)).get();
    }
//    * Stretch Goal
//      * /population/median
//      * return the country with the median population
    @GetMapping("median")
    public Country getAllCountriesWithMedianPop() {
        var countryPop = countries.stream()
                .sorted(Comparator.comparingInt(Country::getPopulation)).collect(Collectors.toList());
        return countryPop.get(countryPop.size()/2);
    }
}
