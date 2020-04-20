package com.charles.supershot.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

import com.charles.supershot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SyncGameInfoActivity extends BaseActivity {
    private static final String TAG = SyncGameInfoActivity.class.getSimpleName();

    @BindView(R.id.cv_confirm)
    CardView cv_confirm;

    @BindView(R.id.cv_no)
    CardView cv_no;

    @BindView(R.id.iv_close)
    ImageView iv_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sync_gameinfo);
        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void attachEvents() {
        cv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //callActivity(JoinConfirmActivity.class, false);
            }
        });

        cv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //callActivity(JoinConfirmActivity.class, false);
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
