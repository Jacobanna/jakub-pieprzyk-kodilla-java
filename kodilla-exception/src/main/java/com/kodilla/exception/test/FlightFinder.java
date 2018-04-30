package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private HashMap<Flight,Boolean> possibleRoutes;

    public FlightFinder() {
        HashMap<Flight, Boolean> routes = new HashMap<>();
        Flight flight1 = new Flight("Kraków","Warszawa");
        Flight flight2 = new Flight("Kraków", "Gdańsk");
        Flight flight3 = new Flight("Kraków", "Szczecin");
        Flight flight4 = new Flight("Warszawa","Kraków");
        Flight flight5 = new Flight("Warszawa","Gdańsk");
        Flight flight6 = new Flight("Warszawa","Szczecin");
        Flight flight7 = new Flight("Gdańsk","Warszawa");
        Flight flight8 = new Flight("Gdańsk","Kraków");
        Flight flight9 = new Flight("Gdańsk","Szczecin");
        Flight flight10 = new Flight("Szczecin","Gdańsk");
        Flight flight11 = new Flight("Szczecin","Kraków");
        Flight flight12 = new Flight("Szczecin","Warszawa");
        routes.put(flight1, true);
        routes.put(flight2, true);
        routes.put(flight3, true);
        routes.put(flight4, true);
        routes.put(flight5, false);
        routes.put(flight6, true);
        routes.put(flight7, false);
        routes.put(flight8, true);
        routes.put(flight9, false);
        routes.put(flight10, false);
        routes.put(flight11, true);
        routes.put(flight12, true);
        this.possibleRoutes = routes;
    }

    public HashMap<Flight, Boolean> getPossibleRoutes() {
        return possibleRoutes;
    }

    public boolean findFlight(Flight flight){

        for(Map.Entry<Flight, Boolean> entry : possibleRoutes.entrySet()){
            if(flight.getArrivalAirport() == entry.getKey().getArrivalAirport() && flight.getDepartureAirport() == entry.getKey().getDepartureAirport()){
                return entry.getValue();
            }
        }
        return false;
    }
}
