package com.bwie.myxutils;

import org.xutils.x;

/**
 * Time:2017/8/29 11:36
 * Author:王才文
 * Description:
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(false);


    }
}
