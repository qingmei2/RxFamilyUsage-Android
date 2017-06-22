package com.qingmei2.sample_rxpermissions.rx02_command.Sample1;

/**
 * Created by QingMei on 2017/6/22.
 * desc:
 */

public class MyFileReceiver implements FileReceiver{
    @Override
    public void openFile() {
        System.out.println("打开文件");
    }

    @Override
    public void writeFile() {
        System.out.println("写文件");
    }

    @Override
    public void closeFile() {
        System.out.println("关闭文件");
    }
}
