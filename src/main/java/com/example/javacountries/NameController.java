package com.example.javacountries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequestMapping("names")
@RestController
public class NameController {
    private List<Country> countries;

    public NameController() {
        this.countries = CountryList.countryList;
    }

    @GetMapping(path = "/all")
    public List<String> getAllCountries() {
        return countries.stream()
                .map(Country::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
