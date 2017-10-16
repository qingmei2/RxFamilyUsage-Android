package com.qingmei2.sample_rxpermissions;

import android.app.Application;

import rx_activity_result2.RxActivityResult;

/**
 * Created by QingMei on 2017/7/10.
 * desc:
 */

public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        this.application = this;

        //注册RxActivityResult
        RxActivityResult.register(this);
    }

    public static BaseApplication getApplication() {
        return application;
    }
}
