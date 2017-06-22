package com.qingmei2.sample_rxpermissions.rx02_command.Sample1;

/**
 * Created by QingMei on 2017/6/22.
 * desc:
 */

public class FileInvoker<T> {

    private T t;

    public void call(Runnable runnable) {
        runnable.run();
    }

    public void setCall(T t) {
        this.t = t;
    }

    public void call(Action1<T> action1){
        action1.call(t);
    }
}
