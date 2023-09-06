package com.example.rxjava.example;

import com.example.rxjava.example.common.Car;
import com.example.rxjava.example.common.CarMaker;
import com.example.rxjava.example.common.SampleData;
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
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

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

//        Mono <Object> mono = Mono.create ( sink -> {
//            // 데이터를 발행하는것이 아니라 특정 작업을 수행한 후, 완료를 통지한다.
//            int sum = 0;
//            for ( int i = 0; i < 100; i++ ) {
//                sum += i;
//            }
//            Logger.log ( LogType.PRINT, "# 합계: " + sum );
//            sink.success ( sum );
//        } );
//        mono.subscribeOn ( Schedulers.boundedElastic () ).subscribe (data -> log.info ( "성공!" + data ), error -> log.warn ( "실패!" ));
//        TimeUtil.sleep ( 100L );

//        Flux.interval ( Duration.ofMillis ( 0L ), Duration.ofMillis ( 1000L ) )
//            .map ( n -> n + " count" )
//            .subscribe (data -> log.info ( "data : {} ", data ));
//        TimeUtil.sleep ( 3000 );

//        Flux <Integer> source = Flux.range ( 0, 5 );
//        source.subscribe (num -> log.info ( "data : {}", num ));

//        log.info ( "start!!!" );
//        Mono <String> map = Mono.delay ( Duration.ofMillis ( 2000L ) )
//                                .map ( count -> "Do work!" );
//        map.subscribe (data -> log.info ( "data : {}", data ));
//        TimeUtil.sleep ( 3000 );

//        Flux <LocalTime> timeFlux = Flux.just ( LocalTime.now ( ) );
//        Flux <LocalTime> defer = Flux.defer ( ( ) -> {
//            LocalTime now = LocalTime.now ( );
//            return Flux.just ( now );
//        } );
//        defer.subscribe (time -> log.info ( "defer1의 구독 시간 : {}", time ));
//        timeFlux.subscribe (time -> log.info ( "just1의 구독 시간 : {}", time ));
//
//        Thread.sleep ( 1000L );
//
//        defer.subscribe (time -> log.info ( "defer2의 구독 시간 : {}", time ));
//        timeFlux.subscribe (time -> log.info ( "just2의 구독 시간 : {}", time ));

//        Flux.fromIterable ( Arrays.asList( "K", "C", "U", "I" ) )
//            .subscribe (country -> log.info ( "country : {}", country ));

//        log.info ( "# Start time" );
//        CompletableFuture <Double> longtimeWorkFuture = CompletableFuture.supplyAsync ( ( ) -> {
//            log.info ( "# 장시간 처리 중....." );
//            TimeUtil.sleep ( 6000L );
//            return 10000000000000.0;
//        } );
//        //짧은 시간 작업
//        TimeUtil.sleep ( 3000L );
//        log.info ( "# 단시간 처리 완료!" );
//        Mono.fromFuture ( longtimeWorkFuture ).subscribe (data -> log.info ( "# 장시간 작업 결과 : {}", data ));
//
//        Thread.sleep ( 4000L );
//
//        log.info ( "# end time" );

//        Flux.fromIterable ( SampleData.carList )
//            .filter ( car -> car.getCarMaker () == CarMaker.CHEVROLET )
//            .filter ( car -> car.getCarPrice () > 30000000 )
//            .subscribe (car -> log.info(car.getCarMaker () + " : " + car.getCarName ()));

//        Flux.fromIterable (SampleData.carList )
//            .distinct ( Car::getCarMaker)
//            .subscribe (car -> log.info(" Car Name : {} ", car.getCarName ()));

//        Flux.interval ( Duration.ofMillis ( 1000 ) )
//            .take ( Duration.ofMillis ( 3500 ) )
//            .subscribe (data -> log.info ( "data : {}", data ));
//        TimeUtil.sleep ( 3500 );

//        Flux.fromIterable ( SampleData.carList )
//            .takeUntil ( car -> car.getCarName ().equals ( "트랙스" ) )
//            .subscribe ( car -> log.info ( "name : {}", car.getCarName () ) );

//        Flux.interval ( Duration.ofMillis ( 300 ) )
//            .skip ( Duration.ofMillis ( 1000 ) )
//            .subscribe ( data -> log.info ( "data : {}", data ) );
//        TimeUtil.sleep ( 3000 );

//        Flux.range ( 1, 15 )
//                .skipLast ( 3 )
//                .subscribe (data -> log.info ( ""+data ));

//        Flux.range ( 2, 8 )
//            .filter ( data -> data % 2 == 0 )
//            .flatMap ( up -> Flux.range ( 1, 9 )
//                                        .map ( down -> up + " * " + down + " = " + up * down ))
//            .subscribe (System.out::println);

//        Flux <GroupedFlux <CarMaker, Car>> groupBy = Flux.fromIterable ( SampleData.carList )
//                                                        .groupBy ( Car::getCarMaker );
//        groupBy.subscribe (flux -> flux.sort ( Comparator.comparing ( Car::getCarMaker ) )
//                                       .subscribe (
//                    car -> log.info ( "group : {}", flux.key () + "\t Car name : " + car.getCarName () ) ));

        Flux.fromIterable ( SampleData.carList )
            .collectMap ( Car::getCarName, Car::getCarMaker )
            .subscribe (System.out::println);
    }
}
