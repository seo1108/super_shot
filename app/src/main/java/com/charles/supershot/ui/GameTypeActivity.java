package com.charles.supershot.ui;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.aigestudio.wheelpicker.WheelPicker;
import com.charles.supershot.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameTypeActivity extends BaseActivity implements WheelPicker.OnItemSelectedListener {
    private static final String TAG = ServiceAgreeActivity.class.getSimpleName();

    @BindView(R.id.iv_info)
    ImageView iv_info;

    @BindView(R.id.ll_game_type)
    LinearLayout ll_game_type;

    @BindView(R.id.tv_game_type)
    TextView tv_game_type;

    @BindView(R.id.ll_wheel)
    LinearLayout ll_wheel;

    @BindView(R.id.main_wheel_center)
    WheelPicker main_wheel_center;

    @BindView(R.id.tv_done)
    TextView tv_done;

    @BindView(R.id.cv_next)
    CardView cv_next;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    private String[] mGameArray;
    private List<String> mArr;

    private String mSelectedText = "";

    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_game_type);
        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        mGameArray = getResources().getStringArray(R.array.gametype);
        mArr = new ArrayList<>();

        for (int idx = 0; idx < mGameArray.length; idx++) {
            mArr.add(mGameArray[idx]);
        }

        Typeface typeface = ResourcesCompat.getFont(mActivity, R.font.roboto_regular);
        float spTextSize = 20;
        float textSize = spTextSize * getResources().getDisplayMetrics().scaledDensity;

        main_wheel_center.setData(mArr);
        //main_wheel_center.setItemTextSize((int) textSize);
        main_wheel_center.setItemSpace(80);
        main_wheel_center.setTypeface(typeface);
        main_wheel_center.setOnItemSelectedListener(this);
//        main_wheel_center.setIndicator(true);
//        main_wheel_center.setIndicatorColor(R.color.black_16);


    }

    @Override
    protected void attachEvents() {
        iv_info.setOnClickListener(v->{
            callActivity(GameGuideActivity.class, false);
        });

        ll_game_type.setOnClickListener(v->{
            cv_next.setVisibility(View.GONE);
            ll_wheel.setVisibility(View.VISIBLE);
        });

        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(mSelectedText)) {
                    tv_game_type.setText(mSelectedText);
                    ll_wheel.setVisibility(View.GONE);
                    cv_next.setVisibility(View.VISIBLE);
                }
            }
        });

        cv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String text = "";
        switch (picker.getId()) {
            case R.id.main_wheel_center:
                text = "Center:";
                break;

        }

        mSelectedText = String.valueOf(data);
    }
}

