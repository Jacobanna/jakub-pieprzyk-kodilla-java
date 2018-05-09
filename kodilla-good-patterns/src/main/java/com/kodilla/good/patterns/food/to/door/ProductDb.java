package com.kodilla.good.patterns.food.to.door;

import java.util.HashMap;
import java.util.Map;

public class ProductDb {
    private Map<Product, Integer> productsDb = new HashMap<>();

    public void addProduct(Product product, int amount) {
        System.out.println(amount + "x " + product.getName() + " added to database.");
        productsDb.put(product,amount);
    }

    public boolean removeProduct(Product product, int amount) {
        for(Map.Entry<Product, Integer> entry: getProductsDb().entrySet()) {
            if(entry.getKey().equals(product)) {
                if(entry.getValue() < amount) {
                    return false;
                } else if(entry.getValue() == amount) {
                    productsDb.remove(entry.getKey());
                    return true;
                } else {
                    productsDb.put(product, entry.getValue()-amount);
                    return true;
                }
            }
        }
        return false;
    }

    public Map<Product, Integer> getProductsDb() {
        return productsDb;
    }
}
