package com.adrian.testdemo.models;

/**
 * Created by qing on 2017/9/30 0030.
 */

public class ErrorXmlBean {
    private String code;
    private String timestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorXmlBean{" +
                "code='" + code + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
