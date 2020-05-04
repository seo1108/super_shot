package com.charles.supershot.ui;

import android.app.Activity;
import android.os.Bundle;

import com.charles.supershot.R;

import butterknife.ButterKnife;

public class GameOptionActivity extends BaseActivity {
    private static final String TAG = GameOptionActivity.class.getSimpleName();

    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_game_option);
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
