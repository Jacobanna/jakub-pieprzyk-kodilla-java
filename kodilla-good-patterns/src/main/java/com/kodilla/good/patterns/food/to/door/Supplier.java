package com.kodilla.good.patterns.food.to.door;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Supplier implements Order {
    private String companyName;
    private int companyId;
    private Map<Product, Integer> companyProducts = new HashMap<>();

    public Supplier(String companyName, int companyId) {
        this.companyName = companyName;
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public Map<Product, Integer> getCompanyProducts() {
        return companyProducts;
    }

    @Override
    public boolean process(ProductDb productDb) {
        //Implementation in extending classes
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(getCompanyName(), supplier.getCompanyName()) &&
                Objects.equals(getCompanyId(), supplier.getCompanyId()) &&
                Objects.equals(getCompanyProducts(), supplier.getCompanyProducts());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCompanyName(), getCompanyId(), getCompanyProducts());
    }
}
