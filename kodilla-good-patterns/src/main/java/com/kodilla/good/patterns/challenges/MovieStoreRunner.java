package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieStoreRunner {
    private static String s;



    public static void main ( String[] args) {
        MovieStore movieStore = new MovieStore();

        s = movieStore.getMovies().entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(s);
    }
}
