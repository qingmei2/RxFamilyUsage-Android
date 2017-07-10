package com.qingmei2.sample_rxpermissions.rx02_cache.api;

import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;

/**
 * Created by QingMei on 2017/7/10.
 * desc:
 */

public class CacheProviders {

    private static UserCacheProviders userCacheProviders;

    public synchronized static UserCacheProviders getUserCache() {
        if (userCacheProviders == null) {
            userCacheProviders = new RxCache.Builder()
                    .persistence(BaseApplication.getApplication().getExternalCacheDir(), new GsonSpeaker())
                    .using(UserCacheProviders.class);
        }
        return userCacheProviders;
    }
}
