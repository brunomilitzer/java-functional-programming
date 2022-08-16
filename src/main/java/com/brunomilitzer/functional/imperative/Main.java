package com.brunomilitzer.functional.imperative;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main( String[] args ) {
        List<Person> people = List.of(
                new Person( "Vanessa", Gender.FEMALE ),
                new Person( "Tales", Gender.MALE ),
                new Person( "Bruno", Gender.MALE ),
                new Person( "Teresa", Gender.FEMALE ),
                new Person( "Helen", Gender.FEMALE )
        );

        // Imperative approach
        final List<Person> females = new ArrayList<>();

        for ( final Person person : people ) {

            if ( Gender.FEMALE.equals( person.gender ) ) {
                females.add( person );
            }
        }

        for ( final Person female : females ) {
            System.out.println(female);
        }
    }

    static class Person {

        private final String name;

        private final Gender gender;

        public Person( String name, Gender gender ) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

    }

    enum Gender {
        MALE, FEMALE
    }

}
