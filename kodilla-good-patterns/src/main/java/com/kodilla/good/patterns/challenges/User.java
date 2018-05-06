package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String surname;
    private Map<Product, Integer> userProducts = new HashMap<>();

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Map<Product, Integer> getUserProducts() {
        return userProducts;
    }

    public void addUserProduct(Product product, int amount){
        userProducts.put(product, amount);
    }
}
