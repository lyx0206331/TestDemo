package com.adrian.testdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adrian.testdemo.R;
import com.adrian.testdemo.gifplay.GifPlayActivity;
import com.adrian.testdemo.tools.ConfigTestUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mEarKeyBtn;
    private Button mPhoneCofigBtn;
    private Button mTestGifBtn;
    private Button mTestWaveBtn;
    private Button mMagicViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        mEarKeyBtn = (Button) findViewById(R.id.btn_ear_key);
        mPhoneCofigBtn = (Button) findViewById(R.id.btn_test_cofig);
        mTestGifBtn = (Button) findViewById(R.id.btn_test_gif);
        mTestWaveBtn = (Button) findViewById(R.id.btn_test_wave);
        mMagicViewBtn = (Button) findViewById(R.id.btn_magic_view);
        mEarKeyBtn.setOnClickListener(this);
        mPhoneCofigBtn.setOnClickListener(this);
        mTestGifBtn.setOnClickListener(this);
        mTestWaveBtn.setOnClickListener(this);
        mMagicViewBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

//    @Override
//    protected void initVariables() {
//
//    }
//
//    @Override
//    protected void initViews() {
//        setContentView(R.layout.activity_main);
//        mEarKeyBtn = (Button) findViewById(R.id.btn_ear_key);
//        mEarKeyBtn.setOnClickListener(this);
//    }
//
//    @Override
//    protected void loadData() {
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ear_key:
                Intent intent = new Intent(this, EarKeyActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_test_cofig:
//                Toast.makeText(this, ConfigTestUtil.newInstance().hasGPS(this) ? "有GPS" : "无GPS", Toast.LENGTH_SHORT).show();
                startActivity(PhoneConfigActivity.class);
                break;
            case R.id.btn_test_gif:
                startActivity(GifPlayActivity.class);
                break;
            case R.id.btn_test_wave:
                startActivity(WaveViewActivity.class);
                break;
            default:
                break;
        }
    }
}
