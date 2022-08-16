package com.brunomilitzer.functional.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main( String[] args ) {
        // Normal Java Function
        Customer vanessa = new Customer( "Vanessa", "9999999" );
        greetCustomer( vanessa );

        // Consumer Functional Interface
        greetCustomerConsumer.accept( vanessa );
        greetCustomerConsumerV2.accept( vanessa, true);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber)
            -> System.out.println( "Hello " + customer.customerName
            + (showPhoneNumber ? ", thanks for registering phone number " + customer.customerPhoneNumber : " ********" ));

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println( "Hello " + customer.customerName
            + ", thanks for registering phone number " + customer.customerPhoneNumber );

    static void greetCustomer( Customer customer ) {
        System.out.println( "Hello " + customer.customerName
                + ", thanks for registering phone number " + customer.customerPhoneNumber );
    }

    static void greetCustomerV2( Customer customer, boolean showPhoneNumber ) {
        System.out.println( "Hello " + customer.customerName
                + (showPhoneNumber ? ", thanks for registering phone number " + customer.customerPhoneNumber : " ********" ));
    }

    static class Customer {

        private final String customerName;

        private final String customerPhoneNumber;

        public Customer( String customerName, String customerPhoneNumber ) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }

    }

}
