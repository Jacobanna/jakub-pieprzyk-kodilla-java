package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class ShopStore implements ProductStore {
    private Map<Product,Integer> products = new HashMap<>();

    @Override
    public void addProduct(Product product, int amount){
        products.put(product,amount);
    }

    @Override
    public void removeProduct(Product product, int amount) {
        for (Map.Entry<Product, Integer> entry: getProducts().entrySet()) {
            if(entry.getKey() == product) {
                if(entry.getValue() > amount){
                    return;
                } else if(entry.getValue() == amount) {
                    products.remove(entry);
                } else {
                    products.put(entry.getKey(), entry.getValue()-amount);
                }
            }
        }
    }

    @Override
    public Map<Product,Integer> getProducts() {
        return products;
    }
}
