package com.qingmei2.sample_rxpermissions.rx02_cache.api;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by QingMei on 2017/6/23.
 * desc:
 */

public interface GitHubService {

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("users/{user}")
    Observable<User> getRxUser(@Path("user") String user);

}
