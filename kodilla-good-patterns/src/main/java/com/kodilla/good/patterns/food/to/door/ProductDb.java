package com.kodilla.good.patterns.food.to.door;

import java.util.HashMap;
import java.util.Map;

public class ProductDb {
    private Map<Product, Integer> productsDb = new HashMap<>();

    public void addProduct(Product product, int amount) {
//        for(Map.Entry<Product, Integer> entry: getProductsDb().entrySet()) {
//
//        }
        System.out.println(amount + "x " + product + " added to database.");
        productsDb.put(product,amount);
    }

    public boolean removeProduct(Product product, int amount) {
        for(Map.Entry<Product, Integer> entry: getProductsDb().entrySet()) {
            if(entry.getKey() == product) {
                if(entry.getValue() > amount) {
                    System.out.println("Cannot remove " + amount + "x " +  product.getName() + " ,there are only " + entry.getValue() + " in the store.");
                    return false;
                } else if(entry.getValue() == amount) {

                }
            }
        }
        return false;
    }

    public Map<Product, Integer> getProductsDb() {
        return productsDb;
    }
}
