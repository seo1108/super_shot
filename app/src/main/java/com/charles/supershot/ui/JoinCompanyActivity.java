package com.charles.supershot.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.charles.supershot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JoinCompanyActivity extends BaseActivity {
    private static final String TAG = JoinCompanyActivity.class.getSimpleName();

    @BindView(R.id.tv_service_2)
    TextView tv_service_2;

    @BindView(R.id.cv_confirm)
    CardView cv_confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_company);
        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void attachEvents() {
        tv_service_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(ServiceAgreeActivity.class, false);
            }
        });

        cv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(JoinCompanyConfirmActivity.class, false);
            }
        });
    }
}
