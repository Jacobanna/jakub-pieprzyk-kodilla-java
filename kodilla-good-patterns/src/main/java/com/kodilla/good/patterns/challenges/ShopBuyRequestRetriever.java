package com.kodilla.good.patterns.challenges;

public class ShopBuyRequestRetriever implements BuyRequestRetriever {
    private User user;
    private Product product;
    private int amount;

    @Override
    public void retrieve() {
        this.user = new User("Adam","Nowak");
        this.product = new Product("Volleyball", 150321);
        this.amount = 2;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
