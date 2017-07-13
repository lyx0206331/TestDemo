package com.adrian.testdemo.application;

import android.app.Application;

/**
 * Created by qing on 2017/7/13 0013.
 */

public class MyApplication extends Application {

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
