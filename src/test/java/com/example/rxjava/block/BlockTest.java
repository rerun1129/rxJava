package com.example.rxjava.block;

import com.example.rxjava.example.common.Car;
import com.example.rxjava.example.common.CarMaker;
import com.example.rxjava.example.common.SampleData;
import com.example.rxjava.example.common.SampleFlux;
import com.example.rxjava.example.utils.LogType;
import com.example.rxjava.example.utils.Logger;
import com.example.rxjava.example.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.*;
import static io.reactivex.Scheduler.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlockTest {
    @Test
    public void getCarStreamFirstTest(){
        // when
        Car car = SampleFlux.getCarStream ( ).blockFirst ( );
        String actual = car.getCarName();

        // then
        assertThat(actual, is("말리부"));
    }

    @Test
    public void getSalesOfBranchAFirstTest() throws InterruptedException {
        boolean result = Observable.interval(200L, TimeUnit.MILLISECONDS)
                                   .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                                   .map(data -> {
                                       if(data == 2)
                                           throw new RuntimeException("Error happened");
                                       return data;
                                   })
                                   .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE))
                                   .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, error.getMessage()))
                                   .test()
                                   .awaitCount(5)
                                   .isTerminated();
        assertThat(result, is(true));
    }
}
