package com.kodilla.good.patterns.flight;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.kodilla.good.patterns.flight.Airport.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Connections connections = new Connections();
        int action;
        String selection;

//        connections.flightFromOneToAnother(KRAKÓW, GDAŃSK);

        while (true) {
            System.out.println("AVAILABLE AIRPORTS: ");
            for (Map.Entry<Airport, List<Airport>> entry : connections.getAvailableRoutes().entrySet()) {
                System.out.println(entry.getKey());
            }
            System.out.println("CHOOSE ACTION:");
            System.out.println("1. FIND ALL POSSIBLE ROUTES TO SELECTED AIRPORT,");
            System.out.println("2. FIND ALL POSSIBLE ROUTES FROM SELECTED AIRPORT,");
            System.out.println("3. FIND CONNECTION FROM ONE AIRPORT TO ANOTHER (ONE CONNECTING FLIGHT MAX),");
            System.out.println("0. EXIT.");
            action = scanner1.nextInt();
            switch (action) {
                case 1:
                    System.out.print("SELECT AIRPORT: ");
                    selection = scanner2.nextLine();
                    System.out.println(selection);
                    Airport selectedAirport = StringToAirport.stringToAirport(selection);
                    System.out.println(selectedAirport);
                    if(selectedAirport != ERROR) {
                        connections.allFlightsFrom(selectedAirport);
                    } else {
                        System.out.println("AIRPORT NOT AVAILABLE. TRY AGAIN.");
                        break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                        System.out.println("NOT POSSIBLE, TRY AGAIN.");
                        action = scanner1.nextInt();
            }
        }
    }
}
