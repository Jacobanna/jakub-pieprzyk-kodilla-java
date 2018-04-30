package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Kraków", "Warszawa");
        Flight flight2 = new Flight("Warszawa", "Gdańsk");
        Flight flight3 = new Flight("Katowice", "Lublin");

        //1ST FLIGHT - exists, available
        try {
            boolean routeFound = flightFinder.findFlight(flight1);
            if (routeFound == false) {
                throw new RouteNotFoundException();
            }
            System.out.println("Route from " + flight1.getDepartureAirport() + " to " + flight1.getArrivalAirport() + " is available.");

        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight1.getArrivalAirport() + " to " + flight1.getDepartureAirport() + " is unavailable or does not exist in DB!");
        }

        //2ND FLIGHT - exists, unavailable
        try {
            boolean routeFound = flightFinder.findFlight(flight2);
            if (routeFound == false) {
                throw new RouteNotFoundException();
            }
            System.out.println("Route from " + flight2.getDepartureAirport() + " to " + flight2.getArrivalAirport() + " is available.");

        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight2.getArrivalAirport() + " to " + flight2.getDepartureAirport() + " is unavailable or does not exist in DB!");
        }
        //3RD FLIGHT - does not exist
        try {
            boolean routeFound = flightFinder.findFlight(flight3);
            if (routeFound == false) {
                throw new RouteNotFoundException();
            }
            System.out.println("Route from " + flight3.getDepartureAirport() + " to " + flight3.getArrivalAirport() + " is available.");

        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight3.getArrivalAirport() + " to " + flight3.getDepartureAirport() + " is unavailable or does not exist in DB!");
        }

    }
}
