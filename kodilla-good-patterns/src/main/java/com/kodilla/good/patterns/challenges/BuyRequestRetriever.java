package com.kodilla.good.patterns.challenges;

public class BuyRequestRetriever {
    private User user;
    private Product product;
    private int amount;

    public BuyRequestRetriever() {
        this.user = new User("Adam","Nowak");
        this.product = new Product("Volleyball", 150321);
        this.amount = 2;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
