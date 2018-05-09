package com.kodilla.good.patterns.food.to.door;

public class GlutenFreeShopSupplier extends Supplier {
    public GlutenFreeShopSupplier() {
        super("Gluten Free Shop", 0);
    }

    @Override
    public boolean process(ProductDb productDb) {
        return false;
    }
}
