package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShapesFactory {
    @Bean
    public Square createSquare() {
        return new Square();
    }

    @Bean
    public Shape chosenShape() {
        Shape shape;
        Random randomGenerator = new Random();
        int chosen = randomGenerator.nextInt(3);
        if (chosen == 0) {
            shape = new Triangle();
        } else if (chosen == 1) {
            shape = new Circle();
        } else {
            shape = new Square();
        }
        return shape;
    }
}
