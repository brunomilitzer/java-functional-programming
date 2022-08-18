package com.brunomilitzer.functional.finalsection;

import java.util.function.BiFunction;

public class Lambdas {

    public static void main( String[] args ) {

        Integer number = null;
        int counter = 0;

        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");

            System.out.println(age);
            return name.toUpperCase();
        };

        String vanessa = upperCaseName.apply( "vanessa", 42 );

        System.out.println(vanessa);
    }
}
