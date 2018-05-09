package com.kodilla.good.patterns.food.to.door;

import java.util.Map;
import java.util.Scanner;

public class GlutenFreeShopSupplier extends Supplier {
    public GlutenFreeShopSupplier() {
        super("Gluten Free Shop", 0);
    }

    @Override
    public boolean process(ProductDb productDb) {
        Scanner scanner = new Scanner(System.in);
        boolean itemFound = false;
        System.out.print("Gluten Free Shop what product do u want to buy (you can buy only gluten free products): ");
        String orderedProduct = scanner.nextLine();
        for (Map.Entry<Product, Integer> entry: productDb.getProductsDb().entrySet()) {
            if(entry.getKey().getName().equals(orderedProduct) && entry.getKey().getName().contains("gluten free")){
                itemFound = true;
                System.out.print("How much items do u want to buy: ");
                int orderedAmount = scanner.nextInt();
                scanner.nextLine();
                if(entry.getValue() >= orderedAmount) {
                    productDb.removeProduct(entry.getKey(),orderedAmount);
                    getCompanyProducts().put(entry.getKey(),orderedAmount);
                    System.out.println(orderedAmount + "x " + orderedProduct + " successfully ordered, 2 extra rucolas added.");
                    return true;
                } else {
                    System.out.println("There are not enough items in storage.");
                }
            } else if (entry.getKey().getName().equals(orderedProduct) && !entry.getKey().getName().contains("gluten free")) {
                System.out.println("This is not gluten free product.");
                itemFound = true;
            }
        }
        if(itemFound == false) {
            System.out.println("There is no such item.");
        }
        return false;
    }
}
