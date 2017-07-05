package com.adrian.testdemo.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adrian.testdemo.R;
import com.adrian.testdemo.databinding.ActivityMainBinding;
import com.adrian.testdemo.gifplay.GifPlayActivity;
import com.adrian.testdemo.tools.ConfigTestUtil;

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

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
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
    }
}
