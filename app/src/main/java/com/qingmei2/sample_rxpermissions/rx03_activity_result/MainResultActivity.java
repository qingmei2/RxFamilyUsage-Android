package com.qingmei2.sample_rxpermissions.rx03_activity_result;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.qingmei2.sample_rxpermissions.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;
import rx_activity_result2.Result;
import rx_activity_result2.RxActivityResult;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

/**
 * Created by qingmei2 on 2017/10/16 0016.
 */

public class MainResultActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    TextView tvResult;
    @BindView(R.id.btn_open_normal)
    Button btnNormal;
    @BindView(R.id.btn_open_rx)
    Button btnRx;
    @BindView(R.id.btn_open_camera)
    Button btnCamera;

    public static final int REQUEST_CODE_NORMAL = 100;
    public static final int REQUEST_CODE_RX = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_outer);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        //记得先在application中注册
        //如果您使用Fragment，请使用v4包的Fragment，否则将不会被notified
        RxView.clicks(btnNormal)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> this.startByNormal());
        RxView.clicks(btnRx)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> this.startByRxActivityResult());
        RxView.clicks(btnCamera)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .map(v -> new Intent(ACTION_IMAGE_CAPTURE))
                .flatMap(intent -> RxActivityResult.on(this)
                        .startIntent(intent))
                .map(Result::requestCode)
                .subscribe(code -> {
                    tvResult.setText("requestCode = "+code);
                });
    }

    public void startByNormal() {
        startActivityForResult(new Intent(this,
                        SecondResultActivity.class),
                REQUEST_CODE_NORMAL);
    }

    public void startByRxActivityResult() {
        RxActivityResult.on(this)
                .startIntent(new Intent(this, SecondResultActivity.class))
                .map(Result::data)
                .subscribe(this::showResultIntentData);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NORMAL) {
            showResultIntentData(data);
        }
    }

    public void showResultIntentData(Intent data) {
        String content = data.getStringExtra("content");
        tvResult.setText("传回来的内容：");
        tvResult.append(content);
    }
}
