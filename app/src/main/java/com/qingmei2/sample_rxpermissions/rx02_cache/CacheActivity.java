package com.qingmei2.sample_rxpermissions.rx02_cache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qingmei2.sample_rxpermissions.R;
import com.qingmei2.sample_rxpermissions.rx02_cache.api.CacheProviders;
import com.qingmei2.sample_rxpermissions.rx02_cache.api.GitHubServiceManager;
import com.qingmei2.sample_rxpermissions.rx02_cache.api.User;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;

/**
 * Created by QingMei on 2017/7/10.
 * desc:
 */

public class CacheActivity extends AppCompatActivity {

    private static final String TAG = "CacheActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        requestHttp("qingmei2");
    }

    private void requestHttp(String userName) {
        Observable<User> user = new GitHubServiceManager()
                .getUser(userName);
        CacheProviders.getUserCache()
                .getUser(user, new DynamicKey(userName), new EvictDynamicKey(false))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user1 -> Log.i(TAG, "requestHttp: user->" + user1.toString())
                        , Throwable::printStackTrace);

    }
}
