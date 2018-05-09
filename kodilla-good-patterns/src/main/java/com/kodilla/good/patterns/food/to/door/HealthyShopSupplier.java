package com.kodilla.good.patterns.food.to.door;

import java.util.Map;
import java.util.Scanner;

public class HealthyShopSupplier extends Supplier {
    public HealthyShopSupplier() {
        super("Healthy Shop", 2);
    }

    @Override
    public boolean process(ProductDb productDb) {
        Scanner scanner = new Scanner(System.in);
        boolean itemFound = false;
        System.out.print("Healthy Shop what product do u want to buy: ");
        String orderedProduct = scanner.nextLine();
        for (Map.Entry<Product, Integer> entry: productDb.getProductsDb().entrySet()) {
            if(entry.getKey().getName().equals(orderedProduct)){
                itemFound = true;
                System.out.print("How much items do u want to buy: ");
                int orderedAmount = scanner.nextInt();
                scanner.nextLine();
                if(entry.getValue() >= orderedAmount) {
                    productDb.removeProduct(entry.getKey(),orderedAmount);
                    getCompanyProducts().put(entry.getKey(),orderedAmount);
                    for (Map.Entry<Product, Integer> rucolaEntry: productDb.getProductsDb().entrySet()) {
                        if(entry.getKey().getName().equals("rucola")) {
                            productDb.removeProduct(rucolaEntry.getKey(),2);
                            getCompanyProducts().put(entry.getKey(),2);
                        }
                    }
                    System.out.println(orderedAmount + "x " + orderedProduct + " successfully ordered, 2 extra rucolas added.");
                    return true;
                } else {
                    System.out.println("There are not enough items in storage.");
                }
            }
        }
        if(itemFound == false) {
            System.out.println("There is no such item.");
        }
        return false;
    }
}
