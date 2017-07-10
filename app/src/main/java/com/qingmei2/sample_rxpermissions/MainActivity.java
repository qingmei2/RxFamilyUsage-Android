package com.qingmei2.sample_rxpermissions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.qingmei2.sample_rxpermissions.rx01_permissions.RxPermissionsActivity;
import com.qingmei2.sample_rxpermissions.rx02_cache.CacheActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_permissions)
    Button btnPermissions;
    @BindView(R.id.btn_cmd)
    Button btnCmd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        RxView.clicks(btnPermissions)
                .subscribe(v -> startActivity(new Intent(this, RxPermissionsActivity.class)));
        RxView.clicks(btnCmd)
                .subscribe(v -> startActivity(new Intent(this, CacheActivity.class)));
    }

}
