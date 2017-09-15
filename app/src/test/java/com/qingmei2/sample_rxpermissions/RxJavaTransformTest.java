package com.qingmei2.sample_rxpermissions;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

/**
 * Created by QingMei on 2017/9/15.
 * desc:the transfrom opretors in the RxJava.
 */

public class RxJavaTransformTest {

    private final Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private Observable<Integer> ob;

    @Before
    public void setUp() throws Exception {
        ob = Observable.fromArray(nums);
    }

    @Test
    public void bufferTest() throws Exception {
        ob.buffer(3)
                .subscribe(integers -> Observable.fromIterable(integers)
                        .test()
                        .assertComplete()
                        .assertNever(i -> i >= 9));
    }

    @Test
    public void flatMapTest() throws Exception {
        Observable.just(nums)
                .flatMap(Observable::fromArray)
                .map(i -> i + 10)
                .filter(i -> i > 15)
                .test()
                .assertValueAt(2, 18)
                .assertValueCount(3);
    }

    @Test
    public void concatMapTest() throws Exception {
        Observable.just(nums)
                .concatMap(Observable::fromArray)
                .map(i -> i + 10)
                .filter(i -> i > 15)
                .test()
                .assertValueAt(2, 18)
                .assertValueCount(3);
    }

    @Test
    public void groupByTest() throws Exception {
        // I think it is a useless opretor!
    }

    @Test
    public void scanTest() throws Exception {
        // I think it is useless too...
        ob.scan((i1, i2) -> i1 + i2)
                .test()
                .assertValueAt(4, 10)
                .assertValueCount(9);
    }
}
