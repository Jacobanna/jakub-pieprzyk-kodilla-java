package com.kodilla.good.patterns.food.to.door;

public class ProductDbInitializer {
    public static ProductDb initialize() {
        Product product1 = new Product("meat",1,5.30);
        Product product2 = new Product("roll",2,2.10);
        Product product3 = new Product("cheese",3,0.70);
        Product product4 = new Product("onion",4,0.30);
        Product product5 = new Product("rucola",5,0.40);
        Product product6 = new Product("gluten free meat",5,10.20);
        Product product7 = new Product("gluten free roll",7,3.40);
        Product product8 = new Product("gluten free cheese",8,1.50);
        Product product9 = new Product("gluten free onion",9,0.70);
        Product product10 = new Product("gluten free rucola",10,0.80);

        ProductDb productDb = new ProductDb();
        productDb.addProduct(product1, 20);
        productDb.addProduct(product2, 30);
        productDb.addProduct(product3, 25);
        productDb.addProduct(product4, 12);
        productDb.addProduct(product5, 16);
        productDb.addProduct(product6, 8);
        productDb.addProduct(product7, 6);
        productDb.addProduct(product8, 9);
        productDb.addProduct(product9, 11);
        productDb.addProduct(product10, 4);
        return productDb;
    }
}
