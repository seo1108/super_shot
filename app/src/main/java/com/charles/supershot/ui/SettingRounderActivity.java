package com.charles.supershot.ui;

import android.os.Bundle;

import com.charles.supershot.R;

import butterknife.ButterKnife;

public class SettingRounderActivity extends BaseActivity {
    private static final String TAG = SettingRounderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_rounder);


        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void attachEvents() {
    }
}