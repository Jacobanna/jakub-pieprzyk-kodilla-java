package com.kodilla.good.patterns.flight;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.kodilla.good.patterns.flight.Airport.*;

public class Connections {
    private Map<Airport, List<Airport>> availableRoutes = new HashMap<>();

    public Connections() {
        List<Airport> krakówList = new LinkedList<>();
        krakówList.add(POZNAŃ);
        krakówList.add(ŁÓDŹ);
        krakówList.add(WARSZAWA);
        List<Airport> poznańList = new LinkedList<>();
        poznańList.add(KRAKÓW);
        poznańList.add(GDAŃSK);
        poznańList.add(ŁÓDŹ);
        List<Airport> łódźList = new LinkedList<>();
        łódźList.add(KRAKÓW);
        łódźList.add(POZNAŃ);
        łódźList.add(WARSZAWA);
        List<Airport> warszawaList = new LinkedList<>();
        warszawaList.add(KRAKÓW);
        warszawaList.add(ŁÓDŹ);
        warszawaList.add(GDAŃSK);
        List<Airport> gdańskList = new LinkedList<>();
        gdańskList.add(POZNAŃ);
        gdańskList.add(WARSZAWA);
        gdańskList.add(WROCŁAW);
        List<Airport> wrocławList = new LinkedList<>();
        wrocławList.add(GDAŃSK);

        availableRoutes.put(KRAKÓW, krakówList);
        availableRoutes.put(POZNAŃ, poznańList);
        availableRoutes.put(ŁÓDŹ, łódźList);
        availableRoutes.put(WARSZAWA, warszawaList);
        availableRoutes.put(GDAŃSK, gdańskList);
        availableRoutes.put(WROCŁAW, wrocławList);
    }

    public Map<Airport, List<Airport>> getAvailableRoutes() {
        return availableRoutes;
    }

    public void allFlightsFrom(Airport airport) {
        System.out.println("From: " + airport + " you can go to:");
        availableRoutes.entrySet().stream()
                .filter(entry -> entry.getKey() == airport)
                .flatMap(entry -> entry.getValue().stream())
                .forEach(System.out::println);
    }

    public void allFlightsTo() {

    }

    public void flightFromOneToAnother() {

    }
}
