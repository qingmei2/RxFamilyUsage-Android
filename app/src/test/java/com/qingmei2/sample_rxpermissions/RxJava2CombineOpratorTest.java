package com.qingmei2.sample_rxpermissions;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

public class RxJava2CombineOpratorTest {

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
                .assertValueAt(3,4);
    }
}
