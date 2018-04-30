package com.kodilla.exception.test;

import java.util.Map;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Kraków", "Warszawa");
        Flight flight2 = new Flight("Warszawa", "Gdańsk");
        Flight flight3 = new Flight("Katowice", "Lublin");

        //1ST FLIGHT - exists, available
        try {
            int dataIsCorrect = 0;
            for (Map.Entry<Flight, Boolean> entry : flightFinder.getPossibleRoutes().entrySet()) {
                if (flight1.getArrivalAirport() == entry.getKey().getArrivalAirport() && flight1.getDepartureAirport() == entry.getKey().getDepartureAirport()) {
                    dataIsCorrect++;
                    break;
                }
            }
            if(dataIsCorrect == 0){
                throw new RouteNotFoundException();
            }
            boolean routeFound = flightFinder.findFlight(flight1);
            System.out.println("Route from " + flight1.getDepartureAirport() + " to " + flight1.getArrivalAirport() + " is available - " + routeFound);
        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight1.getArrivalAirport() + " to " + flight1.getDepartureAirport() + " does not exist in DB!");
        }

        //2ND FLIGHT - exists, unavailable
        try {
            int dataIsCorrect = 0;
            for (Map.Entry<Flight, Boolean> entry : flightFinder.getPossibleRoutes().entrySet()) {
                if (flight2.getArrivalAirport() == entry.getKey().getArrivalAirport() && flight2.getDepartureAirport() == entry.getKey().getDepartureAirport()) {
                    dataIsCorrect++;
                    break;
                }
            }
            if(dataIsCorrect == 0){
                throw new RouteNotFoundException();
            }
            boolean routeFound = flightFinder.findFlight(flight2);
            System.out.println("Route from " + flight2.getDepartureAirport() + " to " + flight2.getArrivalAirport() + " is available - " + routeFound);
        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight2.getArrivalAirport() + " to " + flight2.getDepartureAirport() + " does not exist in DB!");
        }

        //3RD FLIGHT - does not exist
        try {
            int dataIsCorrect = 0;
            for (Map.Entry<Flight, Boolean> entry : flightFinder.getPossibleRoutes().entrySet()) {
                if (flight3.getArrivalAirport() == entry.getKey().getArrivalAirport() && flight3.getDepartureAirport() == entry.getKey().getDepartureAirport()) {
                    dataIsCorrect++;
                    break;
                }
            }
            if(dataIsCorrect == 0){
                throw new RouteNotFoundException();
            }
            boolean routeFound = flightFinder.findFlight(flight1);
            System.out.println("Route from " + flight3.getDepartureAirport() + " to " + flight3.getArrivalAirport() + " is available - " + routeFound);
        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight3.getArrivalAirport() + " to " + flight3.getDepartureAirport() + " does not exist in DB!");
        }

    }
}
