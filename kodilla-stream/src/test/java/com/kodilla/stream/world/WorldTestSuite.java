package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        BigDecimal polandQuantity = new BigDecimal("40000000");
        Country poland = new Country("Poland", polandQuantity);
        BigDecimal germanyQuantity = new BigDecimal("50000000");
        Country germany = new Country("Germany", germanyQuantity);
        BigDecimal franceQuantity = new BigDecimal("25000000");
        Country france = new Country("France", franceQuantity);
        Set<Country> europeSet = new HashSet<>();
        europeSet.add(poland);
        europeSet.add(germany);
        europeSet.add(france);
        Continent europe = new Continent("Europe", europeSet);

        BigDecimal russiaQuantity = new BigDecimal("100000000");
        Country russia = new Country("Russia", russiaQuantity);
        BigDecimal kazakhstanQuantity = new BigDecimal("30000000");
        Country kazakhstan = new Country("Kazakhstan", kazakhstanQuantity);
        Set<Country> asiaSet = new HashSet<>();
        asiaSet.add(russia);
        asiaSet.add(kazakhstan);
        Continent asia = new Continent("Asia", asiaSet);

        BigDecimal canadaQuantity = new BigDecimal("250000000");
        Country canada = new Country("Canada", canadaQuantity);
        BigDecimal unitedStatesQuantity = new BigDecimal("270000000");
        Country unitedStates = new Country("United States", unitedStatesQuantity);
        Set<Country> northAmericaSet = new HashSet<>();
        northAmericaSet.add(canada);
        northAmericaSet.add(unitedStates);
        Continent northAmerica = new Continent("North America", northAmericaSet);

        Set<Continent> worldSet = new HashSet<>();
        worldSet.add(europe);
        worldSet.add(asia);
        worldSet.add(northAmerica);
        World world = new World(worldSet);

        //When
        BigDecimal peopleQuantityInTheWorld = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantityInTheWorld = new BigDecimal("765000000");
        Assert.assertEquals(expectedPeopleQuantityInTheWorld,peopleQuantityInTheWorld);


    }
}
