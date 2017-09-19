package com.qingmei2.sample_rxpermissions.rxjava;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

public class RxJava2CombineTest {

    private final Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 5};
    private final Character[] chars = new Character[]{'a', 'b', 'c', 'd', 'e'};

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void mergeTest() throws Exception {
        Observable<Integer> ob1 = Observable.just(1, 2, 3);
        Observable<Integer> ob2 = Observable.just(4, 5, 6);

        Observable.merge(ob1, ob2)
                .test()
                .assertValueCount(6)
                .assertValueAt(3, 4);
    }

    @Test
    public void startWithTest() throws Exception {
        Observable.fromArray(nums)
                .startWith(-1)
                .test()
                .assertValueCount(7)
                .assertValueAt(0, -1);
        //也可以这样
        Observable.fromArray(nums)
                .startWith(Observable.just(-1))
                .test()
                .assertValueCount(7)
                .assertValueAt(0, -1);
    }

    @Test
    public void zipTest() throws Exception {
        Observable.zip(Observable.fromArray(nums), Observable.fromArray(chars), (integer, character) -> "" + integer + character)
                .test()
                .assertValueCount(5)
                .assertValueAt(0, "0a");
    }

    @Test
    public void zipWithTest() throws Exception {
        Observable.fromArray(nums)
                .zipWith(Observable.fromArray(chars), (i, c) -> "" + i + c)
                .test()
                .assertValueCount(5)
                .assertValueAt(0, "0a");
    }
}
