package com.brunomilitzer.functional.combinatorpattern;

import java.time.LocalDate;

import static com.brunomilitzer.functional.combinatorpattern.CustomerRegistrationValidator.*;
import static com.brunomilitzer.functional.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {

    public static void main( String[] args ) {
        Customer customer = new Customer(
                "Vanessa",
                "vanessadegarcez@gmail.com",
                "+012345678",
                LocalDate.of( 1979, 10, 7 ) );

        //System.out.println(new CustomerValidatorService().isValid( customer ));

        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and( isPhoneNumberValid()
                        .and( isAnAdult() ) )
                .apply( customer );

        System.out.println(result);

        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
