package com.kodilla.good.patterns.food.to.door;

import java.util.HashMap;
import java.util.Map;

public class Supplier {
    private String companyName;
    private String companyId;
    private Map<Product, Integer> companyProducts = new HashMap<>();

    public Supplier(String companyName, String companyId) {
        this.companyName = companyName;
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Map<Product, Integer> getCompanyProducts() {
        return companyProducts;
    }
}
