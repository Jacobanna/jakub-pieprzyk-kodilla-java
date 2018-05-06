package com.kodilla.good.patterns.challenges;

public interface BuyRequestRetriever {
    void retrieve();
    User getUser();
    Product getProduct();
    int getAmount();
}
