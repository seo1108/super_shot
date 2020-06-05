package com.charles.supershot.ui;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import com.aigestudio.wheelpicker.WheelPicker;
import com.charles.supershot.R;
import com.developer.messageview.MessageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameOptionActivity extends BaseActivity implements WheelPicker.OnItemSelectedListener {
    private static final String TAG = GameOptionActivity.class.getSimpleName();

    @BindView(R.id.layout)
    RelativeLayout layout;

    @BindView(R.id.constraint)
    ConstraintLayout constraint;

    @BindView(R.id.ll_first)
    LinearLayout ll_first;

    @BindView(R.id.ll_second)
    LinearLayout ll_second;

    @BindView(R.id.ll_third)
    LinearLayout ll_third;

    @BindView(R.id.ll_fourth)
    LinearLayout ll_fourth;

    @BindView(R.id.ll_fifth)
    LinearLayout ll_fifth;

    @BindView(R.id.ll_sixth)
    LinearLayout ll_sixth;

    @BindView(R.id.mv_double)
    MessageView mv_double;

    @BindView(R.id.mv_bonus)
    MessageView mv_bonus;

    @BindView(R.id.mv_oecd)
    MessageView mv_oecd;

    @BindView(R.id.mv_penalty)
    MessageView mv_penalty;

    @BindView(R.id.ll_per_hole_amount)
    LinearLayout ll_per_home_amount;

    @BindView(R.id.tv_per_hole_amount)
    TextView tv_per_hole_amount;

    @BindView(R.id.ll_wheel)
    LinearLayout ll_wheel;

    @BindView(R.id.main_wheel_center)
    WheelPicker main_wheel_center;

    @BindView(R.id.tv_done)
    TextView tv_done;

    Activity mActivity;

    private String mGameType = "";
    private String mGameSubType = "";

    private String[] mBetArray;
    private List<String> mBetArr;

    private String[] mScoreArray;
    private List<String> mScoreArr;

    private String mSelectedAmount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_game_option);
        ButterKnife.bind(this);

        mGameType = getIntent().getStringExtra("gameType");
        mGameSubType = getIntent().getStringExtra("gameSubType");

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        mBetArray = getResources().getStringArray(R.array.betAmount);
        mBetArr = new ArrayList<>();

        for (int idx = 0; idx < mBetArray.length; idx++) {
            mBetArr.add(mBetArray[idx]);
        }

        mScoreArray = getResources().getStringArray(R.array.scoreOption);
        mScoreArr = new ArrayList<>();

        for (int idx = 0; idx < mScoreArray.length; idx++) {
            mScoreArr.add(mScoreArray[idx]);
        }

        Typeface typeface = ResourcesCompat.getFont(mActivity, R.font.roboto_regular);
        float spTextSize = 20;
        float textSize = spTextSize * getResources().getDisplayMetrics().scaledDensity;

        ll_wheel.setVisibility(View.GONE);

        main_wheel_center.setData(mBetArr);
        main_wheel_center.setItemTextSize((int) textSize);

        main_wheel_center.setIndicator(true);
        main_wheel_center.setIndicatorColor(R.color.black_16);

        main_wheel_center.setItemSpace(50);
        main_wheel_center.setTypeface(typeface);
        main_wheel_center.setOnItemSelectedListener(this);

        if ("skins".equals(mGameType))
        {
            if ("skins".equals(mGameSubType))
            {


            }
            else if ("jopok_skins".equals(mGameSubType))
            {


            }
            else if ("ggol_skins".equals(mGameSubType))
            {


            }
            else if ("hussein".equals(mGameSubType))
            {


            }
            else if ("lasvagas".equals(mGameSubType))
            {


            }
            else if ("new_lasvagas".equals(mGameSubType))
            {


            }
            else if ("against".equals(mGameSubType))
            {


            }
            else if ("nassau".equals(mGameSubType))
            {


            }

        }
        else if ("stroke".equals(mGameType))
        {
            if ("stroke".equals(mGameSubType))
            {


            }
            else if ("scratch".equals(mGameSubType))
            {


            }
            else if ("onebest".equals(mGameSubType))
            {


            }
            else if ("team_stroke".equals(mGameSubType))
            {


            }
            else if ("team_scratch".equals(mGameSubType))
            {


            }
            else if ("random_scratch".equals(mGameSubType))
            {


            }
            else if ("honest".equals(mGameSubType))
            {


            }
        }
        else if ("match".equals(mGameType))
        {
            if ("fourball_best".equals(mGameSubType))
            {


            }
            else if ("fourball_stroke".equals(mGameSubType))
            {


            }
            else if ("threeball_best".equals(mGameSubType))
            {


            }
            else if ("threeball_stroke".equals(mGameSubType))
            {


            }
            else if ("foursome".equals(mGameSubType))
            {


            }
            else if ("threesome".equals(mGameSubType))
            {


            }
            else if ("foursome_scramble".equals(mGameSubType))
            {


            }
        }
        else if ("myeongrang".equals(mGameType))
        {
           if ("stroke".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("scratch".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("team_stroke".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("team_scratch".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("random_scratch".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("fourball_best".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("threeball_best".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("foursome".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("threesome".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("foursome_scramble".equals(mGameSubType))
            {
                ll_first.setVisibility(View.GONE);
                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fourth.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void attachEvents() {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ll_per_home_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(mSelectedAmount)) {
                    tv_per_hole_amount.setText(mSelectedAmount);
                    ll_wheel.setVisibility(View.GONE);
                    //cv_next.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @OnClick(R.id.iv_back)
    void onClickBack() {
        finish();
    }

    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String text = "";
        switch (picker.getId()) {
            case R.id.main_wheel_center:
                text = "Center:";
                break;

        }

        mSelectedAmount = String.valueOf(data);
    }

}
