package com.brunomilitzer.functional.streams;

import java.util.List;
import java.util.function.Predicate;

import static com.brunomilitzer.functional.streams._Stream.Gender.FEMALE;
import static com.brunomilitzer.functional.streams._Stream.Gender.MALE;
import static com.brunomilitzer.functional.streams._Stream.Gender.UNKNOWN;

public class _Stream {

    public static void main( String[] args ) {
        List<Person> people = List.of(
                new Person( "Vanessa", FEMALE ),
                new Person( "Tales", MALE ),
                new Person( "Bruno", MALE ),
                new Person( "Teresa", FEMALE ),
                new Person( "Helen", FEMALE ),
                new Person( "Xyz", UNKNOWN )
        );

        /*people.stream().map( person -> person.name )
                .mapToInt( String::length )
                .forEach( System.out::println );*/

        Predicate<Person> personPredicate = person -> person.gender.equals( UNKNOWN );

        boolean containsOnlyFemales = people.stream().noneMatch( personPredicate );

        System.out.println(containsOnlyFemales);


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
        MALE, FEMALE, UNKNOWN
    }
}
