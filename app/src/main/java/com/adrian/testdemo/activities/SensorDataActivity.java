package com.adrian.testdemo.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import com.adrian.testdemo.R;
import com.adrian.testdemo.databinding.ActivitySensorDataBinding;
import com.adrian.testdemo.databinding.SensorData;
import com.adrian.testdemo.tools.CommUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SensorDataActivity extends AppCompatActivity implements SensorEventListener {

    private SensorData sensorData;

    private SensorManager sm;

    private String logName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_data);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        ActivitySensorDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sensor_data);
        sensorData = new SensorData(this);
        binding.setSensorData(sensorData);

        binding.tvSensorInfo.setMovementMethod(ScrollingMovementMethod.getInstance());

        logName = System.currentTimeMillis() + ".log";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterSensor();
    }

    public void registerSensor() {
        Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensor != null) {
            sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void unregisterSensor() {
        sm.unregisterListener(this);
    }

    private void save2File(String fileName, String content) {
        CommUtil.logE("SAVE", "save log");
        BufferedWriter bw = null;
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/TestDemo");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            CommUtil.logE("SAVE", content);
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath() + "/" + fileName, true)));
            bw.write(content);
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        final String eventInfo = "sensorName:" + event.sensor.getName() + " timestamp:" + event.timestamp + " accuracy:" + event.accuracy + " values:[" + event.values[0] + "|" + event.values[1] + "|" + event.values[2] + "]";
//        CommUtil.logE("SENSOR", eventInfo);
//        CommUtil.logE("SENSORCHANGED", "cur:" + System.currentTimeMillis() + " timestamp:" + event.timestamp);
        sensorData.append("\n" + eventInfo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                save2File(logName, "\n" + eventInfo);

            }
        }).start();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        CommUtil.logE("AccuracyChanged", "accuracy:" + accuracy);
    }
}
