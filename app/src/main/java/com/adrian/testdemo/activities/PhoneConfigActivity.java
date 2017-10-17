package com.adrian.testdemo.activities;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adrian.basemodule.activitiy.BaseActivity;
import com.adrian.testdemo.R;
import com.adrian.testdemo.adapters.ConfigListAdapter;
import com.adrian.testdemo.models.ConfigInfo;
import com.adrian.testdemo.tools.ConfigTestUtil;

import java.util.ArrayList;
import java.util.List;

public class PhoneConfigActivity extends BaseActivity {

    private static RecyclerView recyclerview;
    private ConfigListAdapter mAdapter;
    private List<ConfigInfo> configs;
    private LinearLayoutManager mLayoutMgr;

    private BluetoothAdapter mBluetoothAdapter;
    private static final int REQUEST_ENABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    @Override
    protected void initViews() {

        recyclerview=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerview.setHasFixedSize(true);
        mLayoutMgr = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(mLayoutMgr);
        List<ConfigInfo> data = new ArrayList<>();
        data.add(new ConfigInfo("MEM:", ConfigTestUtil.newInstance().getTotalMem(this).totalMem/1024/1024 + "MB", "无"));
        data.add(new ConfigInfo("GPS:", ConfigTestUtil.newInstance().hasGPS(PhoneConfigActivity.this) ? "有" : "无"));
        data.add(new ConfigInfo("BLE:", ConfigTestUtil.newInstance().supportBLE(this) ? "支持" : "不支持", "Android6.0及以上需要开启定位"));
        mAdapter = new ConfigListAdapter(this, data);
        recyclerview.setAdapter(mAdapter);
        //设置分隔线
//        recyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        mAdapter.addItem(new ConfigInfo("GPS:", ConfigTestUtil.newInstance().hasGPS(PhoneConfigActivity.this) ? "有" : "无"));
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_phone_config;
    }
}
