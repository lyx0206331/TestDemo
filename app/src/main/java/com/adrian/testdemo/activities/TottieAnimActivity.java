package com.adrian.testdemo.activities;

import android.os.Bundle;

import com.adrian.basemodule.activitiy.BaseActivity;
import com.adrian.testdemo.R;

public class TottieAnimActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
//        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
//        animationView.setImageAssetsFolder("images/");
//        animationView.setAnimation("data_demo.json");
//        animationView.loop(true);
//        animationView.playAnimation();

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_tottie_anim;
    }

}
