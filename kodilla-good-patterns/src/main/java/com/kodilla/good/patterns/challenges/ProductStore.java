package com.kodilla.good.patterns.challenges;

import java.util.Map;

public interface ProductStore {
    void addProduct(Product product, int amount);
    void removeProduct(Product product, int amount);
    Map<Product,Integer> getProducts();
}
