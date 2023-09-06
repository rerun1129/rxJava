package com.example.rxjava.example;

import com.example.rxjava.example.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import static java.time.Duration.ofMillis;

@Slf4j
public class TestOperator {
    public static void main ( String[] args ) {
        Flux.just ( 10, 12, 15, 16 )
            .zipWith (Flux.just ( 1,2,0,4 ) ,(a,b) -> {
                        try {
                            return (a / b);
                        }catch ( ArithmeticException ex ){
                            log.error ( "{}", ex.getMessage () );
                            throw ex;
                        }
            })
            .retry (3)
            .onErrorReturn ( -1 )
            .subscribe (
                data -> log.info ( "{}", data ),
                error -> log.error ( "{}", error.getMessage () )
            );
        TimeUtil.sleep ( 5000 );
    }
}
