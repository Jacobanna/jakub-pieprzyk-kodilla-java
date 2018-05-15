package com.kodilla.good.patterns.flight;

import static com.kodilla.good.patterns.flight.Airport.*;

public class StringToAirport {
    public  static Airport stringToAirport(String string) {
        String stringU = string.toUpperCase();
        System.out.println(stringU);
        if(stringU == "KRAKÓW") {
            return KRAKÓW;
        } else if (stringU == "WROCŁAW") {
            return WROCŁAW;
        } else if (stringU == "GDAŃSK") {
            return GDAŃSK;
        } else if (stringU == "WARSZAWA") {
            return WARSZAWA;
        } else if (stringU == "ŁÓDŹ") {
            return ŁÓDŹ;
        } else if (stringU == "POZNAŃ") {
            return POZNAŃ;
        } else {
            return ERROR;
        }
    }
}
