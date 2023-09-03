package com.example.rxjava.example;

import java.util.Arrays;
import java.util.List;

public class ImperativeProgramming {
    public static void main ( String[] args ) {
        List <Integer> integerList = Arrays.asList ( 1, 3, 21, 10, 8, 11 );
        int sum = 0;
        for ( int integer : integerList ) {
            if(integer > 6 && (integer % 2 != 0)){
                sum += integer;
            }
        }
        System.out.println ( sum );
    }
}
