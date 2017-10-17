package com.adrian.basemodule.app;

import android.app.Application;

/**
 * Created by qing on 2017/10/16 0016.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
