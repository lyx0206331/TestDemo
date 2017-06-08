package com.adrian.testdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adrian.testdemo.R;

public class EarKeyActivity extends BaseActivity implements View.OnClickListener {

    private TextView mPressKeyTV;
    private Button mTestBtn;
    private Button mCleanBtn;

    private boolean isPrepared;
    private long start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        mPressKeyTV = (TextView) findViewById(R.id.tv_press_key);
        mTestBtn = (Button) findViewById(R.id.btn_test);
        mCleanBtn = (Button) findViewById(R.id.btn_clean);
        mTestBtn.setOnClickListener(this);
        mCleanBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_ear_key;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        isPrepared = false;
        long interval = System.currentTimeMillis() - start;
        start = 0;
        switch (keyCode) {
            case KeyEvent.KEYCODE_HEADSETHOOK:
                mPressKeyTV.append("onKeyUp-Center : " + interval + "\n");
                return false;
            case KeyEvent.KEYCODE_VOLUME_UP:
                mPressKeyTV.append("onKeyUp-VolumeUp : " + interval + "\n");
                return false;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                mPressKeyTV.append("onKeyUp-VolumeDown : " + interval + "\n");
                return false;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        isPrepared = true;
        Log.e("TAG", "keyCode:" + keyCode);
        start = System.currentTimeMillis();
        switch (keyCode) {
            case KeyEvent.KEYCODE_HEADSETHOOK:
                mPressKeyTV.append("onKeyDown-Center\n");
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                mPressKeyTV.append("onKeyDown-VolumeUp\n");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                mPressKeyTV.append("onKeyDown-VolumeDown\n");
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                mPressKeyTV.append("onKeyLongPress-VolumeUp\n");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                mPressKeyTV.append("onKeyLongPress-VolumeDown\n");
                break;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                if (isPrepared) {
                    mPressKeyTV.append("Test\n");
                }
                break;
            case R.id.btn_clean:
                mPressKeyTV.setText("");
                break;
            default:
                break;
        }
    }
}
