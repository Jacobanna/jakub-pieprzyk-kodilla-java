package com.kodilla.good.patterns.food.to.door;

public class Application {
    public static void main(String[] args) {
        ProductDb productDb = ProductDbInitializer.initialize();
        SupplierDb supplierDb = SupplierDbInitializer.initialize();

        Supplier extra = supplierDb.getSupplierList().get(0);
        extra.process(productDb);

    }
}
