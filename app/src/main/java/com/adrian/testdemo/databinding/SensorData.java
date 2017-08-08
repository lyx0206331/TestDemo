package com.adrian.testdemo.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.adrian.testdemo.BR;
import com.adrian.testdemo.activities.SensorDataActivity;

/**
 * Created by qing on 2017/8/7 0007.
 */

public class SensorData extends BaseObservable {

    private boolean isStart;
    private String btnText = "打开传感器";
    private String sensor_data = "传感器信息";
    private StringBuilder sb = new StringBuilder();
    private SensorDataActivity activity;

    public SensorData() {
    }

    public SensorData(SensorDataActivity act) {
        this.activity = act;
    }

    @Bindable
    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
        notifyPropertyChanged(BR.btnText);
    }

    public void append(String str) {
        sb.append(str);
        setSensor_data(sb.toString());
    }

    @Bindable
    public String getSensor_data() {
        return sensor_data;
    }

    public void setSensor_data(String sensor_data) {
        this.sensor_data = sensor_data;
        notifyPropertyChanged(BR.sensor_data);
    }

    public void clickStart(View view) {
        isStart = !isStart;
        if (isStart) {
            setBtnText("关闭传感器");
            activity.registerSensor();
        } else {
            setBtnText("打开传感器");
            activity.unregisterSensor();
        }
    }

}
