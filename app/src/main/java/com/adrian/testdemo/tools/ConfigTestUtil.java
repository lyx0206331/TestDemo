package com.adrian.testdemo.tools;

import android.app.ActivityManager;
import android.app.ActivityManager.*;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;

import java.util.List;

/**
 * Created by ranqing on 2017/5/8.
 */

public class ConfigTestUtil {
    private static ConfigTestUtil instance;
    private ConfigTestUtil(){}
    public static ConfigTestUtil newInstance() {
        if (instance == null) {
            instance = new ConfigTestUtil();
        }
        return instance;
    }

    /**
     * 是否有GPS
     * @param context
     * @return
     */
    public boolean hasGPS(Context context) {
        LocationManager mgr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (mgr == null) {
            return false;
        }
        List<String> providers = mgr.getAllProviders();
        if (providers == null) {
            return false;
        }
        return providers.contains(LocationManager.GPS_PROVIDER);
    }

    /**
     * 是否支持BLE
     * @param context
     * @return
     */
    public boolean supportBLE(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE);
    }

    /**
     * 获取内存信息，api16以上
     * @param context
     * @return
     */
    public MemoryInfo getTotalMem(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        MemoryInfo memInfo = new MemoryInfo();
        am.getMemoryInfo(memInfo);
        return memInfo;
    }
}
