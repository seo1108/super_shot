package com.charles.supershot.ui;

import android.os.Bundle;

import com.charles.supershot.R;

import butterknife.ButterKnife;

public class SettingTeamActivity extends BaseActivity {
    private static final String TAG = SettingTeamActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_team);


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
