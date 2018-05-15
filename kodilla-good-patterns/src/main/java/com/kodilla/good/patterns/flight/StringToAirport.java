package com.kodilla.good.patterns.flight;

import static com.kodilla.good.patterns.flight.Airport.*;

public interface StringToAirport {
    public static Airport stringToAirport(String string) {
        String stringU = string.toUpperCase();
        if(stringU.equals("KRAKÓW")) {
            return KRAKÓW;
        } else if (stringU.equals("WROCŁAW")) {
            return WROCŁAW;
        } else if (stringU.equals("GDAŃSK")) {
            return GDAŃSK;
        } else if (stringU.equals("WARSZAWA")) {
            return WARSZAWA;
        } else if (stringU.equals("ŁÓDŹ")) {
            return ŁÓDŹ;
        } else if (stringU.equals("POZNAŃ")) {
            return POZNAŃ;
        } else {
            return ERROR;
        }
    }
}
