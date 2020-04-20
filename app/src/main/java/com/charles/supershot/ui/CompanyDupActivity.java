package com.charles.supershot.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.charles.supershot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompanyDupActivity extends BaseActivity {
    private static final String TAG = CompanyDupActivity.class.getSimpleName();

    @BindView(R.id.tv_desc)
    TextView tv_desc;

    @BindView(R.id.cv_confirm)
    CardView cv_confirm;

    @BindView(R.id.iv_close)
    ImageView iv_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_company_dup);
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
                callActivity(SyncInfoActivity.class, true);
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