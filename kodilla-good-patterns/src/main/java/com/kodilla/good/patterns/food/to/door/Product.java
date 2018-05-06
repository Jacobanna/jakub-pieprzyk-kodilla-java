package com.kodilla.good.patterns.food.to.door;

import java.util.Objects;

public class Product {
    private String name;
    private int idNumber;
    private double price;

    public Product(String name, int idNumber, double price) {
        this.name = name;
        this.idNumber = idNumber;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getIdNumber() == product.getIdNumber() &&
                Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getIdNumber(), getPrice());
    }
}
