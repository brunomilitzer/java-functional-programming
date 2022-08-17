package com.brunomilitzer.functional.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main( String[] args ) {

        System.out.println( "Without predicate" );
        System.out.println( isPhoneNumberValid( "07000000000" ) );
        System.out.println( isPhoneNumberValid( "0700000000" ) );
        System.out.println( isPhoneNumberValid( "09000770000" ) );

        System.out.println( "With predicate" );
        System.out.println( isPhoneNumberValidPredicate.test( "07000000000" ) );
        System.out.println( isPhoneNumberValidPredicate.test( "0700000000" ) );
        System.out.println( isPhoneNumberValidPredicate.test( "09000773000" ) );

        System.out.println(
                "Is phone number valid and contains 3 = " +
                isPhoneNumberValidPredicate.and( containsNumber3Predicate ).test( "0700000000" )
        );

        System.out.println(
                "Is phone number valid and contains 3 = " +
                        isPhoneNumberValidPredicate.and( containsNumber3Predicate ).test( "07000773000" )
        );

        System.out.println(
                "Is phone number valid or contains 3 = " +
                        isPhoneNumberValidPredicate.or( containsNumber3Predicate ).test( "070007730" )
        );

        System.out.println("Has valid area code and phone number is valid = " +
                hasValidAreaCodeAndPhoneNumberIsValid.test( "087", "1753298" ));
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith( "07" ) && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3Predicate = phoneNumber -> phoneNumber.contains( "3" );

    static BiPredicate<String, String> hasValidAreaCodeAndPhoneNumberIsValid = (areaCode, phoneNumber) ->
            areaCode.length() == 3 && areaCode.startsWith( "0" )
                    && !phoneNumber.startsWith( "0" ) && phoneNumber.length() == 7;

    static boolean isPhoneNumberValid( String phoneNumber ) {
        return phoneNumber.startsWith( "07" ) && phoneNumber.length() == 11;
    }

}
