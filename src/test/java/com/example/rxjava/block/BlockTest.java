package com.example.rxjava.block;

import com.example.rxjava.example.common.Car;
import com.example.rxjava.example.common.CarMaker;
import com.example.rxjava.example.common.SampleData;
import com.example.rxjava.example.common.SampleFlux;
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
    public void getSalesOfBranchAFirstTest(){
        fromArray (SampleData.carMakersDuplicated)
                .subscribeOn ( Schedulers.computation () )
                .filter(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
                .test()
                .awaitDone(1L, TimeUnit.MILLISECONDS)
                .assertValues(CarMaker.CHEVROLET, CarMaker.CHEVROLET);
    }
}
