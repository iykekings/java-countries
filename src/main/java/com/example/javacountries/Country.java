package com.example.javacountries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    private String name;
    private int population;
    private int landMass;
    private int medianAge;

//    public Country(String name, int population, int landMass, int medianAge) {
//        this.name = name;
//        this.population = population;
//        this.landMass = landMass;
//        this.medianAge = medianAge;
//    }
        public Country(@JsonProperty("name") String name, @JsonProperty("population") int population,
                   @JsonProperty("landMass") int landMass, @JsonProperty("medianAge") int medianAge) {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getLandMass() {
        return landMass;
    }

    public int getMedianAge() {
        return medianAge;
    }
}
