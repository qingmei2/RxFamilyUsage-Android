package com.qingmei2.sample_rxpermissions;

import com.qingmei2.sample_rxpermissions.rx02_command.Sample1.FileInvoker;
import com.qingmei2.sample_rxpermissions.rx02_command.Sample1.MyFileReceiver;

import org.junit.Test;

/**
 * Created by QingMei on 2017/6/22.
 * desc:
 */

public class lambdaTest {

    @Test
    public void lambdaTest1() throws Exception {
        FileInvoker invoker = new FileInvoker();
        MyFileReceiver myFileReceiver = new MyFileReceiver();
        invoker.call(myFileReceiver::openFile);
        invoker.call(myFileReceiver::writeFile);
        invoker.call(myFileReceiver::closeFile);
        invoker.setCall("设置的字符串");
        invoker.call(System.out::print);
    }
}
