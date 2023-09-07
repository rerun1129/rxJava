package com.example.rxjava.example;

import com.example.rxjava.example.common.Car;
import com.example.rxjava.example.common.CarMaker;
import com.example.rxjava.example.common.SampleData;
import com.example.rxjava.example.utils.LogType;
import com.example.rxjava.example.utils.Logger;
import com.example.rxjava.example.utils.TimeUtil;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;

@Slf4j
public class TestOperator {
    public static void main ( String[] args ) {
        Flux <CarMaker> flux1 =
                Flux.fromArray ( SampleData.carMakers )
                    .subscribeOn ( Schedulers.immediate () )
                    .delaySequence ( ofMillis ( 500 ) )
                    .doOnNext ( data -> log.info ( "Flux1 : {}", data ) );
        Flux <CarMaker> flux2 =
                Flux.fromArray ( SampleData.carMakersDuplicated )
                    .delaySequence ( ofMillis ( 1000 ) )
                    .doOnNext ( data -> log.info ( "Flux2 : {}", data ) );
        Mono.sequenceEqual ( flux1, flux2 )
            .subscribe ( data -> log.info ( "{}", data ) );
        TimeUtil.sleep ( 2000 );
    }

}
