package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    public static void main(String[] args) {
        ProductStoreInitializer productStoreInitializer = new ProductStoreInitializer();
        ProductStore productStore = productStoreInitializer.getProductStore();
        BuyRequestRetriever buyRequestRetriever = new BuyRequestRetriever();
        BuyRequest.buyProduct(buyRequestRetriever.getUser(),buyRequestRetriever.getProduct(),buyRequestRetriever.getAmount(),productStore);
    }
}
