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
        System.out.print("What product do u want to buy: ");
        String orderedProduct = scanner.nextLine();
        for (Map.Entry<Product, Integer> entry: productDb.getProductsDb().entrySet()) {
            if(entry.getKey().getName() == orderedProduct){
                System.out.print("How much items do u want to buy: ");
                int orderedAmount = scanner.nextInt();
                scanner.nextLine();
                if(entry.getValue() > orderedAmount) {
                    productDb.removeProduct(entry.getKey(),orderedAmount);
                    getCompanyProducts().put(entry.getKey(),orderedAmount);
                    System.out.println(orderedAmount + "x " + orderedProduct + " successfully ordered.");
                    return true;
                } else {
                    System.out.println("There are not enough items in storage.");
                }
            } else {
                System.out.println("There is no such item.");
            }
        }
        return false;
    }
}
