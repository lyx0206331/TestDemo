package com.adrian.testdemo.application;

import android.app.Application;

import com.adrian.basemodule.app.BaseApplication;

/**
 * Created by qing on 2017/7/13 0013.
 */

public class MyApplication extends BaseApplication {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
