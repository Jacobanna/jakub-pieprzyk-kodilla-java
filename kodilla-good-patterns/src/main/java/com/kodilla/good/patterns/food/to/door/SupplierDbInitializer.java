package com.kodilla.good.patterns.food.to.door;

public class SupplierDbInitializer {
    public static SupplierDb initialize() {
        Supplier extraFoodShopSupplier = new ExtraFoodShopSupplier();
        Supplier glutenFreeShopSupplier = new GlutenFreeShopSupplier();
        Supplier healthyShopSupplier = new HealthyShopSupplier();

        SupplierDb supplierDb = new SupplierDb();
        supplierDb.addSupplier(extraFoodShopSupplier);
        supplierDb.addSupplier(glutenFreeShopSupplier);
        supplierDb.addSupplier(healthyShopSupplier);
        return supplierDb;
    }
}
