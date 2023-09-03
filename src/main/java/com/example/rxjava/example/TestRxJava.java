package com.example.rxjava.example;

import com.example.rxjava.example.utils.TimeUtil;
import com.example.rxjava.example.utils.*;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class TestRxJava {
    public static void main(String[] args){
        Completable completable = Completable.create ( emitter -> {
            // 데이터를 발행하는것이 아니라 특정 작업을 수행한 후, 완료를 통지한다.
            int sum = 0;
            for(int i =0; i < 100; i++){
                sum += i;
            }
            Logger.log(LogType.PRINT, "# 합계: " + sum);

            emitter.onComplete();
        } );



        completable.subscribeOn(Schedulers.computation())
                   .subscribe(
                           () -> Logger.log(LogType.ON_COMPLETE),
                           error -> Logger.log(LogType.ON_ERROR, error)
                             );

        TimeUtil.sleep(100L);
    }
}
