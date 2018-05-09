package com.kodilla.good.patterns.food.to.door;

public class Application {
    public static void main(String[] args) {
        ProductDb productDb = ProductDbInitializer.initialize();
        SupplierDb supplierDb = SupplierDbInitializer.initialize();
        supplierDb.getSupplierList().get(0).process(productDb);
        supplierDb.getSupplierList().get(1).process(productDb);
        supplierDb.getSupplierList().get(2).process(productDb);
    }
}
