package com.adrian.testdemo.gifplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.adrian.testdemo.R;
import com.adrian.testdemo.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends BaseActivity {

    private static final int NUMBER_CELLS = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        List<String> imageUrls = new ArrayList<>();
        for (int i = 0; i < NUMBER_CELLS; i++) {
            imageUrls.add("https://cloud.githubusercontent.com/assets/4410820/11539468/c4d62a9c-9959-11e5-908e-cf50a21ac0e9.gif");
        }

        GifGridAdapter adapter = new GifGridAdapter(this, imageUrls);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_grid_view;
    }
}
