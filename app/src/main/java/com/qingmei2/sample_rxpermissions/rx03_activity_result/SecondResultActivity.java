package com.qingmei2.sample_rxpermissions.rx03_activity_result;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.view.RxView;
import com.qingmei2.sample_rxpermissions.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qingmei2 on 2017/10/16 0016.
 */

public class SecondResultActivity extends AppCompatActivity {

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.btn_commit)
    Button btnCommit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_inner);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        RxView.clicks(btnCommit)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> commitResult());
    }

    public void commitResult() {
        Intent intent = new Intent(this,MainResultActivity.class);
        intent.putExtra("content",etContent.getText().toString());
        setResult(1,intent);
        finish();
    }
}
