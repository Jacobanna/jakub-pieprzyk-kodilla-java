package com.kodilla.good.patterns.flight;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.kodilla.good.patterns.flight.Airport.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connections connections = new Connections();
        int action;

//        Airport airport = KRAKÓW;
//        System.out.println(airport);
//        Map<Airport, List<Airport>> availableRoutes = connections.getAvailableRoutes();
//        availableRoutes.entrySet().stream()
//                .filter(entry -> entry.getKey() == KRAKÓW)
//                .flatMap(entry -> entry.getValue().stream())
//                .forEach(System.out::println);



        while (true) {
            System.out.println("AVAILABLE AIRPORTS: ");
            for (Map.Entry<Airport, List<Airport>> entry : connections.getAvailableRoutes().entrySet()) {
                System.out.println(entry.getKey());
            }
            System.out.println("CHOOSE ACTION:");
            System.out.println("1. FIND ALL POSSIBLE ROUTES TO SELECTED AIRPORT,");
            System.out.println("2. FIND ALL POSSIBLE ROUTES FROM SELECTED AIRPORT,");
            System.out.println("3. FIND CONNECTION FROM ONE AIRPORT TO ANOTHER,");
            System.out.println("0. EXIT.");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.print("SELECT AIRPORT: ");
                    Airport selectedAirport = Airport.valueOf(scanner.nextLine().toUpperCase());
                    connections.allFlightsFrom(selectedAirport);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                        System.out.println("NOT POSSIBLE, TRY AGAIN.");
                        action = scanner.nextInt();
            }
        }
    }
}
