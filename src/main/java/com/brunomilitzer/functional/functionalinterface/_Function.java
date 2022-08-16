package com.brunomilitzer.functional.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main( String[] args ) {
        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne( 1 );
        System.out.println( increment );

        Integer increment2 = incrementByOneFunction.apply( 1 );
        System.out.println( increment2 );

        int multiply = multiplyBy10Function.apply( increment2 );
        System.out.println( multiply );

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen( multiplyBy10Function );

        System.out.println( addBy1AndThenMultiplyBy10.apply( 4 ) );

        System.out.println( incrementByOneAndMultiplyBiFunction.apply( 4, 100 ) );

        // BiFunction takes 2 arguments and produces 1 result
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne( int number ) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            ( numberToIncrementByOne, numberToMultiply )
                    -> ( numberToIncrementByOne + 1 ) * numberToMultiply;

    static int incrementByOneAndMultiply( int number, int numToMultiplyBy ) {
        return ( number + 1 ) * numToMultiplyBy;
    }

}
