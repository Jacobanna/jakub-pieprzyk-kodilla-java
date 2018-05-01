package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Kraków", "Warszawa");
        Flight flight2 = new Flight("Warszawa", "Gdańsk");
        Flight flight3 = new Flight("Katowice", "Lublin");

        //1ST FLIGHT - exists, available
        try {
            if(flightFinder.getPossibleRoutes().containsKey(flight1) == true){
                boolean routeFound = flightFinder.findFlight(flight1);
                System.out.println("Route from " + flight1.getDepartureAirport() + " to " + flight1.getArrivalAirport() + " is available - " + routeFound);
            } else {
                throw new RouteNotFoundException();
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight1.getDepartureAirport() + " to " + flight1.getArrivalAirport() + " does not exist in DB!");
        }

        //2ND FLIGHT - exists, unavailable
        try {
            if(flightFinder.getPossibleRoutes().containsKey(flight2) == true){
                boolean routeFound = flightFinder.findFlight(flight2);
                System.out.println("Route from " + flight2.getDepartureAirport() + " to " + flight2.getArrivalAirport() + " is available - " + routeFound);
            } else {
                throw new RouteNotFoundException();
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight2.getDepartureAirport() + " to " + flight2.getArrivalAirport() + " does not exist in DB!");
        }

        //3RD FLIGHT - does not exist
        try {
            if(flightFinder.getPossibleRoutes().containsKey(flight3) == true){
                boolean routeFound = flightFinder.findFlight(flight3);
                System.out.println("Route from " + flight3.getDepartureAirport() + " to " + flight3.getArrivalAirport() + " is available - " + routeFound);
            } else {
                throw new RouteNotFoundException();
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Route from " + flight3.getDepartureAirport() + " to " + flight3.getArrivalAirport() + " does not exist in DB!");
        }
    }
}
