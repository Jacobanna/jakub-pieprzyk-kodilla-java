package com.kodilla.good.patterns.challenges;

import java.util.Objects;

public class Product {
    private String name;
    private int number;

    public Product(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getNumber() == product.getNumber() &&
                Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getNumber());
    }
}
