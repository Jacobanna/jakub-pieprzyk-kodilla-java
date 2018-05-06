package com.kodilla.good.patterns.challenges;

import java.util.Map;

public class BuyRequest {
    public static boolean buyProduct(User user, Product product, int amount, ProductStore shopStore){
        for (Map.Entry<Product, Integer> entry: shopStore.getProducts().entrySet()){
            if(entry.getKey().equals(product)){
                if(entry.getValue() >= amount){
                    user.addUserProduct(product,amount);
                    shopStore.removeProduct(product,amount);
                    System.out.println("Successfully bought: " + amount + " " + product.getName());
                    return true;
                }
            }
        }
        System.out.println("Item is unavailable");
        return false;
    }
}
