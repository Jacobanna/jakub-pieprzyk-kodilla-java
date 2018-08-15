package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaTestSuite {
    @Test
    public void testPizzaWithExtrasGetCost() {
        //Given
        Pizza pizza = new BasicPizza();
        pizza = new OnionDecorator(pizza);
        pizza = new SalamiDecorator(pizza);
        pizza = new MushroomDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //When
        BigDecimal cost = pizza.getCost();
        //Then
        assertEquals(new BigDecimal(30.5), cost);
    }
    @Test
    public void testPizzaWithExtrasGetDescription() {
        //Given
        Pizza pizza = new BasicPizza();
        pizza = new OnionDecorator(pizza);
        pizza = new SalamiDecorator(pizza);
        pizza = new MushroomDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //When
        String description = pizza.getDescription();
        //Then
        assertEquals("Pizza with: tomato sauce, cheese, onion, salami, mushroom, extra cheese", description);
    }
}
