package com.kodilla.stream.world;

import java.util.Set;

public final class Continent {
    private final String continentName;
    private final Set<Country> countrySet;

    public Continent(final String continentName, final Set<Country> countrySet) {
        this.continentName = continentName;
        this.countrySet = countrySet;
    }

    public Set<Country> getCountrySet() {
        return countrySet;
    }
}
