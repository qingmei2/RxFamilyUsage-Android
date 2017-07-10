package com.qingmei2.sample_rxpermissions.rx02_cache.api;

import android.app.Application;

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
    }

    public static BaseApplication getApplication() {
        return application;
    }
}
