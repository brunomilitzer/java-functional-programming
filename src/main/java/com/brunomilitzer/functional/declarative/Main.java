package com.brunomilitzer.functional.declarative;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main( String[] args ) {
        List<Person> people = List.of(
                new Person( "Vanessa", Gender.FEMALE ),
                new Person( "Tales", Gender.MALE ),
                new Person( "Bruno", Gender.MALE ),
                new Person( "Teresa", Gender.FEMALE ),
                new Person( "Helen", Gender.FEMALE )
        );


        System.out.println("Declarative approach");
        // Declarative approach
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals( person.gender );

        people.stream().filter( personPredicate ).forEach( System.out::println );
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
