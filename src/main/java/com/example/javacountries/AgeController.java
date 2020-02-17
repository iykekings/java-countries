package com.example.javacountries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("age")
@RestController
public class AgeController {
    private List<Country> countries;
    public AgeController() {
        this.countries = CountryList.countryList;
    }
//    * /age/age/{age}
//      * return the countries that have a median age equal to or greater than the given age
        @GetMapping("age/{age}")
        public List<Country> getCountriesWithAge(@PathVariable("age") int age) {
           return countries.stream()
                    .filter(country -> country.getMedianAge() >= age)
                    .collect(Collectors.toList());
        }
//    * /age/min
//      * return the country with the smallest median age
        @GetMapping("min")
        public Country getCountriesMin() {
            return countries.stream()
                    .min(Comparator.comparingInt(Country::getMedianAge)).get();
        }
//    * /age/max
//      * return the country the the greatest median age
        @GetMapping("max")
        public Country getCountriesMax() {
            return countries.stream()
                    .max(Comparator.comparingInt(Country::getMedianAge)).get();
        }
//    * Stretch Goal
//      * /age/median
//      * return the country with the median median age
        @GetMapping("median")
        public Country getAllCountriesWithMedianAge() {
            var countryPop = countries.stream()
                    .sorted(Comparator.comparingInt(Country::getMedianAge)).collect(Collectors.toList());
            return countryPop.get(countryPop.size()/2);
        }
}
