package com.example.rxjava.example.common;

import com.example.rxjava.example.common.Car;
import com.example.rxjava.example.common.CarMaker;
import com.example.rxjava.example.common.SampleData;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * 단위 테스트를 설명하기 위한 Sample Flux 클래스
 */
public class SampleFlux {
    public static Flux <CarMaker> getDuplicatedCarMakerStream ( ) {

        return Flux.fromArray ( SampleData.carMakersDuplicated )
                   .subscribeOn ( Schedulers.parallel ( ) );
    }

    public static Flux<CarMaker> getCarMakerStream() {

        return Flux.fromArray ( SampleData.carMakers )
           .subscribeOn(Schedulers.parallel());
    }

    public static Flux<Car> getCarStream ( ) {
        return Flux
                .fromIterable(SampleData.carList)
                .subscribeOn(Schedulers.parallel());
    }

    public static Flux<Integer> getSalesOfBranchA() {
        return Flux
                .fromIterable(SampleData.salesOfBranchA)
                .subscribeOn(Schedulers.parallel());
    }

    public static Flux<Integer> getSalesOfBranchB() {
        return Flux
                .fromIterable ( SampleData.salesOfBranchB )
                .subscribeOn(Schedulers.parallel());
    }

    public static Flux<Integer> getSalesOfBranchC() {
        return Flux
                .fromIterable(SampleData.salesOfBranchC)
                .subscribeOn(Schedulers.parallel());
    }

    public static Flux<Integer> getSpeedOfSectionA() {
        return Flux
                .fromArray(SampleData.speedOfSectionA)
                .subscribeOn(Schedulers.parallel());
    }

    public static Flux<Integer> getTemperatureOfSeoul() {
        return Flux
                .fromArray(SampleData.temperatureOfSeoul)
                .subscribeOn(Schedulers.parallel());
    }



}