package com.kodilla.good.patterns.food.to.door;

import java.util.LinkedList;
import java.util.List;

public class SupplierDb {
    private List<Supplier> supplierList = new LinkedList<>();

    public boolean addSupplier(Supplier supplier) {
        for (Supplier sup : supplierList) {
            if(sup == supplier) {
                System.out.println(supplier.getCompanyName() + " is already on supplier list.");
                return false;
            }
        }
        System.out.println(supplier.getCompanyName() + " added to supplier list.");
        supplierList.add(supplier);
        return true;
    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }
}
