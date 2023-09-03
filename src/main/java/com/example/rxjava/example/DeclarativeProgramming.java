package com.example.rxjava.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Sinks;

public class DeclarativeProgramming {
    public static void main ( String[] args ) throws InterruptedException {
//        List <Integer> integerList = Arrays.asList ( 1, 3, 21, 10, 8, 11 );
//        int result = integerList.stream ().filter ( n -> n > 6 && (n % 2 != 0) ).mapToInt ( n -> n ).sum ();
//        System.out.println ( result );

//        Flux.just ( 100, 200, 300, 400, 500 )
//            .doOnNext ( item -> System.out.println ( Thread.currentThread ().getName () + ":" + item ) )
//            .subscribeOn ( Schedulers.parallel () )
//            .publishOn ( Schedulers.boundedElastic () )
//            .filter ( n -> n > 300 )
//            .subscribe (item -> System.out.println ( Thread.currentThread ().getName () + ":" + item ) );
//        Thread.sleep ( 500 );

//        Flux.just ( 1,25,9,15,7,30)
//            .filter ( x -> x > 10 )
//            .subscribe (System.out::println);
//        Flux <String> just = Flux.just ( "Hello", "RxJava" );
//        just.subscribe (System.out::println);
//        Flux <Integer> integerFlux = Flux.just ( 1, 3, 5, 7 );
//        integerFlux.subscribe (x -> System.out.println ( "구독자 1 :" + x ));
//        integerFlux.subscribe (x -> System.out.println ( "구독자 2 :" + x ));
        Sinks.Many <Integer> many = Sinks.many ( ).multicast ( ).onBackpressureBuffer ( );
        many.asFlux ().subscribe (x -> System.out.println ( "구독자 1 :" + x ));
        many.emitNext ( 1, Sinks.EmitFailureHandler.FAIL_FAST );
        many.emitNext ( 3, Sinks.EmitFailureHandler.FAIL_FAST );
        many.asFlux ().subscribe (x -> System.out.println ( "구독자 2 :" + x ));
        many.emitNext ( 5, Sinks.EmitFailureHandler.FAIL_FAST );
        many.emitNext ( 7, Sinks.EmitFailureHandler.FAIL_FAST );
    }
}
