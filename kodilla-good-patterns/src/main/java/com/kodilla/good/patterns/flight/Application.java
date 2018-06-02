package com.kodilla.good.patterns.flight;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.kodilla.good.patterns.flight.Airport.*;
import static com.kodilla.good.patterns.flight.StringToAirport.stringToAirport;

public class Application {

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Connections connections = new Connections();
        int action;
        String selection;

        while (true) {
            System.out.println("\nAVAILABLE AIRPORTS: ");
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
                    Airport selectedAirport = stringToAirport(selection);
                    if(selectedAirport != ERROR) {
                        connections.allFlightsFrom(selectedAirport);
                    } else {
                        System.out.println("AIRPORT NOT AVAILABLE. TRY AGAIN.");
                        break;
                    }
                    break;
                case 2:
                    System.out.print("SELECT AIRPORT: ");
                    selection = scanner2.nextLine();
                    selectedAirport = stringToAirport(selection);
                    if(selectedAirport != ERROR) {
                        connections.allFlightsTo(selectedAirport);
                    } else {
                        System.out.println("AIRPORT NOT AVAILABLE. TRY AGAIN.");
                        break;
                    }
                    break;
                case 3:
                    System.out.print("SELECT STARTING AIRPORT: ");
                    selection = scanner2.nextLine();
                    Airport startAirport = stringToAirport(selection);
                    System.out.print("SELECT ENDING AIRPORT: ");
                    selection = scanner2.nextLine();
                    Airport endAirport = stringToAirport(selection);
                    if(startAirport != ERROR && endAirport != ERROR) {
                        connections.flightFromOneToAnother(startAirport, endAirport);
                    } else {
                        System.out.println("AT LEAST ONE OF AIRPORTS NOT AVAILABLE. TRY AGAIN.");
                        break;
                    }
                    break;
                case 0:
                    return;
                default:
                        System.out.println("NOT POSSIBLE, TRY AGAIN.");
                        action = scanner1.nextInt();
            }
        }
    }
}
