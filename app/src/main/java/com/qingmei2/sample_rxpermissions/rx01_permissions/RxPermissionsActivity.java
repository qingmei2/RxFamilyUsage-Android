package com.qingmei2.sample_rxpermissions.rx01_permissions;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.annimon.stream.Optional;
import com.jakewharton.rxbinding2.view.RxView;
import com.qingmei2.sample_rxpermissions.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class RxPermissionsActivity extends AppCompatActivity {

    @BindView(R.id.btn_01)
    Button btn01;
    @BindView(R.id.btn_02)
    Button btn02;
    @BindView(R.id.btn_03)
    Button btn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_permissions);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_01, R.id.btn_02, R.id.btn_03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_01:
                requestPermission();
                break;
            case R.id.btn_02:
                requestPermission2();
                break;
            case R.id.btn_03:
                requestSomePermissions();
                break;
        }
    }

    /**
     * 直接请求权限
     */
    public void requestPermission() {
        new RxPermissions(this)
                .request(Manifest.permission.CAMERA)
                .subscribe(this::dealGranted, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    /**
     * 事件触发请求权限
     */
    private void requestPermission2() {
        RxView.clicks(btn02)
                .compose(new RxPermissions(this).ensure(Manifest.permission.CAMERA))
                .subscribe(this::dealGranted);
    }

    /**
     * 一次请求多个权限并处理
     */
    private void requestSomePermissions() {
        new RxPermissions(this)
                .request(Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE)
                .subscribe(this::dealGranted);
    }

    private void dealGranted(boolean value){
        Optional.ofNullable(value)
                .filter(value1 -> value1)
                .ifPresentOrElse(aBoolean -> Toast.makeText(this, "获取权限成功", Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(this, "获取权限失败", Toast.LENGTH_SHORT).show());
    }


}
