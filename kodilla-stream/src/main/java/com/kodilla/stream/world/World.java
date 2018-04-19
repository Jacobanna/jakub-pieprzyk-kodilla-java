package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Set;

public final class World{
    private final Set<Continent> continentSet;

    public World(final Set<Continent> continentSet) {
        this.continentSet = continentSet;
    }

    BigDecimal getPeopleQuantity(){
        return continentSet.stream()
                .flatMap(continent -> continent.getCountrySet().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));
    }

}
