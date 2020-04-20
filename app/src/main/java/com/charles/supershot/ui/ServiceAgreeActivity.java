package com.charles.supershot.ui;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import com.charles.supershot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceAgreeActivity extends BaseActivity {
    private static final String TAG = ServiceAgreeActivity.class.getSimpleName();

    @BindView(R.id.iv_close)
    ImageView iv_close;

    @BindView(R.id.cv_confirm)
    CardView cv_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service_agree);
        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void attachEvents() {
        cv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

