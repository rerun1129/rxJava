package com.example.rxjava.example;

import com.example.rxjava.example.common.SampleData;
import com.example.rxjava.example.utils.TimeUtil;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.Duration.ofMillis;

@Slf4j
public class TestOperator {
    public static void main ( String[] args ) {
        List <Flux <Integer>> fluxList = Arrays.asList (
                Flux.fromIterable ( SampleData.salesOfBranchA ),
                Flux.fromIterable ( SampleData.salesOfBranchB ),
                Flux.fromIterable ( SampleData.salesOfBranchC )
        );

        Flux.zip ( fluxList, flux -> Arrays.stream( flux ).reduce (0, (acc, a2) -> (int)acc + (int)a2 ) )
            .index ((index, value) -> index + 1 + "월 총매출 : " + value )
            .subscribe (data -> log.info ( "{}", data ));
    }
}
