package com.kodilla.good.patterns.challenges;

public class ProductStoreInitializer {
    ProductStore productStore = new ProductStore();

    public ProductStoreInitializer() {
        Product product1 = new Product("Table", 132111);
        Product product2 = new Product("Pool", 165342);
        Product product3 = new Product("Washing machine", 654231);
        Product product4 = new Product("Volleyball", 150321);
        Product product5 = new Product("Boots", 113309);
        productStore.addProduct(product1, 5);
        productStore.addProduct(product2, 0);
        productStore.addProduct(product3, 20);
        productStore.addProduct(product4, 2);
        productStore.addProduct(product5, 3);
    }

    public ProductStore getProductStore() {
        return productStore;
    }
}
