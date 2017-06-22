package com.qingmei2.sample_rxpermissions.rx02_command;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import com.qingmei2.sample_rxpermissions.R;
import com.qingmei2.sample_rxpermissions.rx02_command.Sample1.FileInvoker;
import com.qingmei2.sample_rxpermissions.rx02_command.Sample1.MyFileReceiver;

public class CommandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);
        sample1();
        sample2();
    }

    @VisibleForTesting
    public void sample1() {
        FileInvoker<String> invoker = new FileInvoker();
        MyFileReceiver myFileReceiver = new MyFileReceiver();
        invoker.call(myFileReceiver::openFile);
        invoker.call(myFileReceiver::writeFile);
        invoker.call(myFileReceiver::closeFile);
        invoker.setCall("设置的字符串");
        invoker.call(System.out::print);
    }

    private void sample2() {
    }

}
