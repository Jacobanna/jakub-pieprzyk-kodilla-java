package com.kodilla.good.patterns.flight;

import static com.kodilla.good.patterns.flight.Airport.*;

public interface StringToAirport {
    public static Airport stringToAirport(String string) {
        String stringU = string.toUpperCase();
        if(stringU.equals("KRAKOW")) {
            return KRAKOW;
        } else if (stringU.equals("WROCLAW")) {
            return WROCLAW;
        } else if (stringU.equals("GDANSK")) {
            return GDANSK;
        } else if (stringU.equals("WARSZAWA")) {
            return WARSZAWA;
        } else if (stringU.equals("LODZ")) {
            return LODZ;
        } else if (stringU.equals("POZNAN")) {
            return POZNAN;
        } else {
            return ERROR;
        }
    }
}
