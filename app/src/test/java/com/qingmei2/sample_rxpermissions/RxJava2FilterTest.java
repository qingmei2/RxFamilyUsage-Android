package com.qingmei2.sample_rxpermissions;

import org.junit.Test;

import io.reactivex.Observable;

/**
 * Created by QingMei on 2017/9/15.
 * desc:
 */

public class RxJava2FilterTest {

    private final Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 5, 4, 3, 2};
    private final String[] strs = new String[]{
            "123",
            "1234",
            new String("123"),
            "123"
    };

    @Test
    public void distinctTest() throws Exception {
        Observable.fromArray(nums)
                .distinct()
                .test()
                .assertValueCount(6)
                .assertValueAt(4, 4)
                .assertNever(i -> i > 5);
    }

    @Test
    public void distinctTest2() throws Exception {
        Observable.fromArray(strs)
                .distinct()
                .test()
                .assertValueCount(2)
                .assertValueAt(1, "1234");
    }

    @Test
    public void elementAtTest() throws Exception {
        Observable.fromArray(nums)
                .elementAt(18,-1)
                .test()
                .assertValueCount(1)
                .assertValue(-1);
    }

    @Test
    public void ofTypeTest() throws Exception {
        Observable.just(1,2,3,"4",5,"6",new Object())
                .ofType(Integer.class)
                .test()
                .assertValueCount(4)
                .assertValueAt(3,5);
    }
}
