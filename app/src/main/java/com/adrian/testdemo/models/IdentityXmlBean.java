package com.adrian.testdemo.models;

/**
 * Created by qing on 2017/9/30 0030.
 */

public class IdentityXmlBean {
    private String accountId;
    private String userName;
    private String deviceId;
    private String verified;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "IdentityXmlBean{" +
                "accountId='" + accountId + '\'' +
                ", userName='" + userName + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", verified='" + verified + '\'' +
                '}';
    }
}
