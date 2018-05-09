package com.kodilla.good.patterns.food.to.door;

public class HealthyShopSupplier extends Supplier {
    public HealthyShopSupplier() {
        super("Healthy Shop", 2);
    }

    @Override
    public boolean process(ProductDb productDb) {

        return false;
    }
}
