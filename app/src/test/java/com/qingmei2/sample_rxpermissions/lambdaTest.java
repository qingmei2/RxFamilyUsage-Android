package com.qingmei2.sample_rxpermissions;

import org.junit.Test;

/**
 * Created by QingMei on 2017/6/22.
 * desc:
 */

public class lambdaTest {

    @Test
    public void lambdaTest1() throws Exception {
        String str = "123";
        test(str);
        str = null;
        Thread.sleep(5000);
    }

    private void test(String str) {
        System.out.println(str);
        new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(str);
            }
        }.run();
    }
}
