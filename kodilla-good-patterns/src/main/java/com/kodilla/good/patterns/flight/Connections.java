package com.kodilla.good.patterns.flight;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kodilla.good.patterns.flight.Airport.*;

public class Connections {
    private Map<Airport, List<Airport>> availableRoutes = new HashMap<>();

    public Connections() {
        List<Airport> krakowList = new LinkedList<>();
        krakowList.add(POZNAN);
        krakowList.add(LODZ);
        krakowList.add(WARSZAWA);
        List<Airport> poznanList = new LinkedList<>();
        poznanList.add(KRAKOW);
        poznanList.add(GDANSK);
        poznanList.add(LODZ);
        List<Airport> lodzList = new LinkedList<>();
        lodzList.add(KRAKOW);
        lodzList.add(POZNAN);
        lodzList.add(WARSZAWA);
        List<Airport> warszawaList = new LinkedList<>();
        warszawaList.add(KRAKOW);
        warszawaList.add(LODZ);
        warszawaList.add(GDANSK);
        List<Airport> gdanskList = new LinkedList<>();
        gdanskList.add(POZNAN);
        gdanskList.add(WARSZAWA);
        gdanskList.add(WROCLAW);
        List<Airport> wroclawList = new LinkedList<>();
        wroclawList.add(GDANSK);

        availableRoutes.put(KRAKOW, krakowList);
        availableRoutes.put(POZNAN, poznanList);
        availableRoutes.put(LODZ, lodzList);
        availableRoutes.put(WARSZAWA, warszawaList);
        availableRoutes.put(GDANSK, gdanskList);
        availableRoutes.put(WROCLAW, wroclawList);
    }

    public Map<Airport, List<Airport>> getAvailableRoutes() {
        return availableRoutes;
    }

    public void allFlightsFrom(Airport airport) {
        System.out.println("FROM " + airport + " YOU CAN GO TO:");
        availableRoutes.entrySet().stream()
                .filter(entry -> entry.getKey() == airport)
                .flatMap(entry -> entry.getValue().stream())
                .forEach(System.out::println);
    }

    public void allFlightsTo(Airport airport) {
        System.out.println("TO " + airport + " YOU CAN GO FROM:");
        availableRoutes.entrySet().stream()
                .filter(entry -> entry.getValue().contains(airport))
                .map(entry -> entry.getKey())
                .forEach(System.out::println);
    }

    public void flightFromOneToAnother(Airport start, Airport end) {
        availableRoutes.entrySet().stream()
                .filter(e -> e.getValue().contains(end))
                .map(e -> e.getKey())
                .collect(Collectors.toList()).stream()
                .filter(a -> availableRoutes.get(start).contains(a))
                .forEach(System.out::println);
//        for (Map.Entry<Airport, List<Airport>> entry : availableRoutes.entrySet()) {
//            if (entry.getKey() == start) {
//                for (Airport possibleEnd : entry.getValue()) {
//                    if (possibleEnd == end) {
//                        System.out.println("FLIGHT FROM " + start + " TO " + end + " AVAILABLE DIRECTLY.");
//                    } else {
//                        List<Airport> availableFromStart = entry.getValue();
//                        for (Map.Entry<Airport, List<Airport>> anotherEntry : availableRoutes.entrySet()) {
//                            if (availableFromStart.contains(anotherEntry.getKey())) {
//                                for(Airport possibleEndSecondary : anotherEntry.getValue()) {
//                                    if(possibleEndSecondary == end) {
//                                        System.out.println("FLIGHT FROM" + start + " " + end + " IS AVAILABLE WITH CONNECTING FLIGHT AT " + anotherEntry.getKey());
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}
