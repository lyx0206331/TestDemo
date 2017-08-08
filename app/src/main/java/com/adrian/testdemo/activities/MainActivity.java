package com.adrian.testdemo.activities;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adrian.testdemo.R;
import com.adrian.testdemo.databinding.ActivityMainBinding;
import com.adrian.testdemo.gifplay.GifPlayActivity;
import com.adrian.testdemo.tools.CommUtil;
import com.adrian.testdemo.tools.ConfigTestUtil;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends BaseActivity {

    private Button mEarKeyBtn;
    private Button mPhoneCofigBtn;
    private Button mTestGifBtn;
    private Button mTestWaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Main main = new Main();
        binding.setMain(main);

    }

    @Override
    protected void loadData() {
        byte[] mac = new byte[6];
        mac[0] = (byte) 0x80;
        mac[1] = 0x67;
        mac[2] = (byte) 0xFF;
        mac[3] = (byte) 0xEE;
        mac[4] = (byte) 0xAB;
        mac[5] = (byte) 0x66;
        mac = Base64.encode(mac, Base64.DEFAULT);
        CommUtil.logE("BASE64", "http://www.iwhere.com/0/" + new String(mac));
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void MyNeedsPermission() {
        startActivity(SensorDataActivity.class);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnShowRationale({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void MyOnShowRationale(final PermissionRequest request) {
    }

    public class Main {
        public void clickEarKey(View view) {
            startActivity(EarKeyActivity.class);
        }

        public void clickTestConfig(View view) {
            startActivity(PhoneConfigActivity.class);
        }

        public void clickTestGif(View view) {
            startActivity(GifPlayActivity.class);
        }

        public void clickTestWave(View view) {
            startActivity(WaveViewActivity.class);
        }

        public void clickTottieAnim(View view) {
            startActivity(TottieAnimActivity.class);
        }

        public void clickSensorTest(View view) {
            MainActivityPermissionsDispatcher.MyNeedsPermissionWithCheck(MainActivity.this);
        }
    }
}
