package com.adrian.testdemo.models;

/**
 * Created by ranqing on 2017/5/8.
 */

public class ConfigInfo {
    public String name;
    public String detail;
    public String tips;

    public ConfigInfo() {
    }

    public ConfigInfo(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public ConfigInfo(String name, String detail, String tips) {
        this.name = name;
        this.detail = detail;
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", tips='" + tips + '\'' +
                '}';
    }
}
