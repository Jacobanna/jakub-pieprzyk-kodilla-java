package com.kodilla.good.patterns.food.to.door;

import java.util.Map;
import java.util.Scanner;

public class ExtraFoodShopSupplier extends Supplier {

    public ExtraFoodShopSupplier() {
        super("Extra Food Shop", 1);
    }

    @Override
    public boolean process(ProductDb productDb) {
        Scanner scanner = new Scanner(System.in);
        boolean itemFound = false;
        System.out.print("Extra Food Shop what product do u want to buy: ");
        String orderedProduct = scanner.nextLine();
        for (Map.Entry<Product, Integer> entry: productDb.getProductsDb().entrySet()) {
            if(entry.getKey().getName().equals(orderedProduct)){
                itemFound = true;
                System.out.print("How much items do u want to buy (adding one extra): ");
                int orderedAmount = scanner.nextInt() + 1;
                scanner.nextLine();
                if(entry.getValue() >= orderedAmount) {
                    productDb.removeProduct(entry.getKey(),orderedAmount);
                    getCompanyProducts().put(entry.getKey(),orderedAmount);
                    System.out.println(orderedAmount + "x " + orderedProduct + " successfully ordered.");
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
