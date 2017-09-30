package com.adrian.testdemo.models;

import android.text.TextUtils;

import com.adrian.testdemo.tools.CommUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by qing on 2017/8/9 0009.
 */

public class SensorBean {
    private String name;
    private String vendor;
    private int version;
    private int type;
    private double maxRange;
    private double resolution;
    private double power;
    private int minDelay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    public double getResolution() {
        return resolution;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getMinDelay() {
        return minDelay;
    }

    public void setMinDelay(int minDelay) {
        this.minDelay = minDelay;
    }

    @Override
    public String toString() {
        return "SensorBean{" +
                "name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                ", version=" + version +
                ", type=" + type +
                ", maxRange=" + maxRange +
                ", resolution=" + resolution +
                ", power=" + power +
                ", minDelay=" + minDelay +
                '}';
    }

    public void parseData(String data) {
        if (TextUtils.isEmpty(data)) {
            return;
        }
        if (data.startsWith("{Sensor ") && data.endsWith("}")) {
            data = data.replace("Sensor", "").replace("=", ":");
            CommUtil.logE("PARSE", data);
            try {
                JSONObject json = new JSONObject(data);
                name = json.optString("name");
                vendor = json.optString("vendor");
                version = json.optInt("version");
                type = json.optInt("type");
                maxRange = json.optDouble("maxRange");
                resolution = json.optDouble("resolution");
                power = json.optDouble("power");
                minDelay = json.optInt("minDelay");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
