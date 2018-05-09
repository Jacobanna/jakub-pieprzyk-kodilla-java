package com.kodilla.good.patterns.food.to.door;

public class ProductDbInitializer {
    public static ProductDb initialize() {
        Product product1 = new Product("meat",1,5.30);
        Product product2 = new Product("roll",2,2.10);
        Product product3 = new Product("cheese",3,0.70);
        Product product4 = new Product("onion",4,0.30);
        Product product5 = new Product("rucola",5,0.40);

        ProductDb productDb = new ProductDb();
        productDb.addProduct(product1, 20);
        productDb.addProduct(product2, 30);
        productDb.addProduct(product3, 25);
        productDb.addProduct(product4, 12);
        productDb.addProduct(product5, 16);
        return productDb;
    }
}
