package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("white")
                .burgers(2)
                .sauce("mayo")
                .ingredient("CHEESE")
                .ingredient("CHILI")
                .build();
        //When
        List<String> expectedIngredients = new ArrayList<>();
        expectedIngredients.add("CHEESE");
        expectedIngredients.add("CHILI");
        //Then
        Assert.assertEquals("white", bigmac.getBun());
        Assert.assertEquals(2, bigmac.getBurgers());
        Assert.assertEquals("mayo", bigmac.getSauce());
        Assert.assertEquals(expectedIngredients, bigmac.getIngredients());
    }
}
