package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    public static void main(String[] args) {
        ProductStoreInitializer shopStoreInitializer = new ShopStoreInitializer();
        shopStoreInitializer.initialize();
        ProductStore shopStore = shopStoreInitializer.getProductStore();
        BuyRequestRetriever shopBuyRequestRetriever = new ShopBuyRequestRetriever();
        shopBuyRequestRetriever.retrieve();
        BuyRequest.buyProduct(shopBuyRequestRetriever.getUser(),shopBuyRequestRetriever.getProduct(), shopBuyRequestRetriever.getAmount(),shopStore);
    }
}
