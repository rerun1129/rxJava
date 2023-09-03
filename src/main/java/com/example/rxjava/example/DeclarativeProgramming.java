package com.example.rxjava.example;

import com.example.rxjava.example.utils.DateUtil;
import com.example.rxjava.example.utils.LogType;
import com.example.rxjava.example.utils.Logger;
import com.example.rxjava.example.utils.TimeUtil;
import io.reactivex.Completable;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.*;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;

@Slf4j
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
//        Sinks.Many <Integer> many = Sinks.many ( ).multicast ( ).onBackpressureBuffer ( );
//        many.asFlux ().subscribe (x -> System.out.println ( "구독자 1 :" + x ));
//        many.emitNext ( 1, Sinks.EmitFailureHandler.FAIL_FAST );
//        many.emitNext ( 3, Sinks.EmitFailureHandler.FAIL_FAST );
//        many.asFlux ().subscribe (x -> System.out.println ( "구독자 2 :" + x ));
//        many.emitNext ( 5, Sinks.EmitFailureHandler.FAIL_FAST );
//        many.emitNext ( 7, Sinks.EmitFailureHandler.FAIL_FAST );
//        Flux.interval ( Duration.ofMillis ( 300L ) )
//            .doOnNext ( data -> log.info ( "interval doOnNext()" + " : " +data ) )
//            .onBackpressureLatest ( )
//            .publishOn ( Schedulers.parallel (), false, 2 )
//            .subscribe (data -> {
//                try {
//                    Thread.sleep ( 1000L );
//                } catch ( InterruptedException e ) {
//                    throw new RuntimeException ( e );
//                }
//                log.info ( String.valueOf ( data ) );
//            }, error -> log.error ( String.valueOf ( error ) ) );
//        Thread.sleep ( 6500L );
//        Mono.justOrEmpty ( Optional.empty ( ) )
//            .subscribe (data -> log.info ( "# 날짜 시각 : " + data ), error -> log.error ( String.valueOf ( error ) ), () -> log.warn ( "No data Notice" ) );
        Mono <Object> mono = Mono.create ( sink -> {
            // 데이터를 발행하는것이 아니라 특정 작업을 수행한 후, 완료를 통지한다.
            int sum = 0;
            for ( int i = 0; i < 100; i++ ) {
                sum += i;
            }
            Logger.log ( LogType.PRINT, "# 합계: " + sum );
            sink.success ( sum );
        } );
        mono.subscribeOn ( Schedulers.boundedElastic () ).subscribe (data -> log.info ( "성공!" + data ), error -> log.warn ( "실패!" ));
        TimeUtil.sleep ( 100L );

    }
}
