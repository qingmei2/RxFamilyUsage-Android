package com.qingmei2.sample_rxpermissions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.qingmei2.sample_rxpermissions.rx01_permissions.RxPermissionsActivity;
import com.qingmei2.sample_rxpermissions.rx02_cache.CacheActivity;
import com.qingmei2.sample_rxpermissions.rx03_activity_result.MainResultActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_permissions)
    Button btnPermissions;
    @BindView(R.id.btn_cache)
    Button btnCmd;
    @BindView(R.id.btn_activity_result)
    Button btnActivityResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        RxView.clicks(btnPermissions)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> startActivity(new Intent(this, RxPermissionsActivity.class)));
        RxView.clicks(btnCmd)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> startActivity(new Intent(this, CacheActivity.class)));
        RxView.clicks(btnActivityResult)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> startActivity(new Intent(this, MainResultActivity.class)));
    }

}
