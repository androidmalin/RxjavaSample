package com.malin.rengwuxianrxjava.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * 类描述:Application
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-12-16 上午11:00
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class RxJavaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
