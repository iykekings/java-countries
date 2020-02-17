package com.example.javacountries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("names")
@RestController
public class NameController {
    private List<Country> countries;

    public NameController() {
        this.countries = CountryList.countryList;
    }

    @GetMapping(path = "/all")
    public List<Country> getAllCountries() {
        return countries.stream()
                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/start/{letter}")
    public List<Country> getAllCountriesStartingWithLetter(@PathVariable("letter") char letter) {
        return countries.stream()
                .filter(country ->
                        Character.toLowerCase(letter) == country.getName().toLowerCase().charAt(0))
                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/size/{number}")
    public List<Country> getCountriesWithLength(@PathVariable("number") int number) {
        return countries.stream()
                .filter(country -> number <= country.getName().length())
                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .collect(Collectors.toList());
    }
}
