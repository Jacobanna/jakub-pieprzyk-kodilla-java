package com.kodilla.good.patterns.food.to.door;

public interface Order {
    boolean process(Supplier supplier, int amount, Product product);
}
