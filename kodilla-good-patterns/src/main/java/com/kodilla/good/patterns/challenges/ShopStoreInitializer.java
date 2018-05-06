package com.kodilla.good.patterns.challenges;

public class ShopStoreInitializer implements ProductStoreInitializer {
    ProductStore shopStore = new ShopStore();

    @Override
    public void initialize() {
        Product product1 = new Product("Table", 132111);
        Product product2 = new Product("Pool", 165342);
        Product product3 = new Product("Washing machine", 654231);
        Product product4 = new Product("Volleyball", 150321);
        Product product5 = new Product("Boots", 113309);
        shopStore.addProduct(product1, 5);
        shopStore.addProduct(product2, 0);
        shopStore.addProduct(product3, 20);
        shopStore.addProduct(product4, 2);
        shopStore.addProduct(product5, 3);
    }

    @Override
    public ProductStore getProductStore() {
        return shopStore;
    }
}