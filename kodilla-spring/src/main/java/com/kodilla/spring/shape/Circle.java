package com.kodilla.spring.shape;

import org.springframework.stereotype.Component;

@Component
public class Circle {
    @Override
    public String getShapeName() {
        return "This is circle"
    }
}
