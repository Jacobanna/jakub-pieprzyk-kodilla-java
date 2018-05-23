package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTestSuite {
    @Test
    public void testDefaultInvestingStrategies() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        //When
        System.out.println("Steven should: " + steven.predict());
        System.out.println("John should: " + john.predict());
        System.out.println("Kodilla should: " + kodilla.predict());

        //Then
        Assert.assertEquals("[Conservative predictor] Buy debentures of XYZ", steven.predict());
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ", john.predict());
        Assert.assertEquals("[Balanced predictor] Buy shared units of fund XYZ", kodilla.predict());
    }

    @Test
    public void testIndividualInvestingStrategy() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");

        //When
        System.out.println("Steven should: " + steven.predict());
        steven.setBuyingStrategy(new AggressivePredictor());
        System.out.println("Steven now should: " + steven.predict());

        //Then
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ", steven.predict());
    }
}