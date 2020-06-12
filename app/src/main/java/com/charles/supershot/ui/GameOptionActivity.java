package com.charles.supershot.ui;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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

    @BindView(R.id.ll_first_desc)
    LinearLayout ll_first_desc;

    @BindView(R.id.tv_first_desc)
    TextView tv_first_desc;

    @BindView(R.id.ll_amount)
    LinearLayout ll_amount;

    @BindView(R.id.tv_amount)
    TextView tv_amount;

    @BindView(R.id.ll_9_prize)
    LinearLayout ll_9_prize;

    @BindView(R.id.et_9_prize)
    EditText et_9_prize;

    @BindView(R.id.ll_18_prize)
    LinearLayout ll_18_prize;

    @BindView(R.id.et_18_prize)
    EditText et_18_prize;

    @BindView(R.id.ll_diff_hole_amount)
    LinearLayout ll_diff_hole_amount;

    @BindView(R.id.tv_diff_hole_amount)
    TextView tv_diff_hole_amount;

    @BindView(R.id.ll_18_diff_hole_amount)
    LinearLayout ll_18_diff_hole_amount;

    @BindView(R.id.tv_18_diff_hole_amount)
    TextView tv_18_diff_hole_amount;

    @BindView(R.id.ll_per_hole_amount)
    LinearLayout ll_per_hole_amount;

    @BindView(R.id.tv_per_hole_amount)
    TextView tv_per_hole_amount;

    @BindView(R.id.ll_second)
    LinearLayout ll_second;

    @BindView(R.id.ll_score_calc)
    LinearLayout ll_score_calc;

    @BindView(R.id.ll_third)
    LinearLayout ll_third;

    @BindView(R.id.ll_third_sub)
    LinearLayout ll_third_sub;

    @BindView(R.id.iv_double_switch)
    ImageView iv_double_switch;

    @BindView(R.id.ll_double_1)
    LinearLayout ll_double_1;

    @BindView(R.id.iv_double_1)
    ImageView iv_double_1;

    @BindView(R.id.ll_double_2)
    LinearLayout ll_double_2;

    @BindView(R.id.iv_double_2)
    ImageView iv_double_2;

    @BindView(R.id.ll_double_3)
    LinearLayout ll_double_3;

    @BindView(R.id.iv_double_3)
    ImageView iv_double_3;

    @BindView(R.id.ll_double_4)
    LinearLayout ll_double_4;

    @BindView(R.id.iv_double_4)
    ImageView iv_double_4;

    @BindView(R.id.ll_double_5)
    LinearLayout ll_double_5;

    @BindView(R.id.iv_double_5)
    ImageView iv_double_5;

    @BindView(R.id.ll_double_6)
    LinearLayout ll_double_6;

    @BindView(R.id.iv_double_6)
    ImageView iv_double_6;

    @BindView(R.id.ll_fourth)
    LinearLayout ll_fourth;

    @BindView(R.id.ll_fourth_sub)
    LinearLayout ll_fourth_sub;

    @BindView(R.id.iv_bonus_switch)
    ImageView iv_bonus_switch;

    @BindView(R.id.ll_bonus_1)
    LinearLayout ll_bonus_1;

    @BindView(R.id.iv_bonus_1)
    ImageView iv_bonus_1;

    @BindView(R.id.ll_bonus_2)
    LinearLayout ll_bonus_2;

    @BindView(R.id.iv_bonus_2)
    ImageView iv_bonus_2;

    @BindView(R.id.ll_bonus_3)
    LinearLayout ll_bonus_3;

    @BindView(R.id.iv_bonus_3)
    ImageView iv_bonus_3;

    @BindView(R.id.ll_bonus_4)
    LinearLayout ll_bonus_4;

    @BindView(R.id.iv_bonus_4)
    ImageView iv_bonus_4;

    @BindView(R.id.ll_bonus_5)
    LinearLayout ll_bonus_5;

    @BindView(R.id.iv_bonus_5)
    ImageView iv_bonus_5;

    @BindView(R.id.ll_fifth)
    LinearLayout ll_fifth;

    @BindView(R.id.ll_fifth_sub)
    LinearLayout ll_fifth_sub;

    @BindView(R.id.iv_oecd_switch)
    ImageView iv_oecd_switch;

    @BindView(R.id.ll_oecd_1)
    LinearLayout ll_oecd_1;

    @BindView(R.id.iv_oecd_1)
    ImageView iv_oecd_1;

    @BindView(R.id.ll_oecd_2)
    LinearLayout ll_oecd_2;

    @BindView(R.id.iv_oecd_2)
    ImageView iv_oecd_2;

    @BindView(R.id.ll_oecd_3)
    LinearLayout ll_oecd_3;

    @BindView(R.id.iv_oecd_3)
    ImageView iv_oecd_3;

    @BindView(R.id.ll_oecd_4)
    LinearLayout ll_oecd_4;

    @BindView(R.id.iv_oecd_4)
    ImageView iv_oecd_4;

    @BindView(R.id.ll_oecd_5)
    LinearLayout ll_oecd_5;

    @BindView(R.id.iv_oecd_5)
    ImageView iv_oecd_5;

    @BindView(R.id.ll_oecd_6)
    LinearLayout ll_oecd_6;

    @BindView(R.id.iv_oecd_6)
    ImageView iv_oecd_6;

    @BindView(R.id.ll_oecd_7)
    LinearLayout ll_oecd_7;

    @BindView(R.id.iv_oecd_7)
    ImageView iv_oecd_7;

    @BindView(R.id.ll_sixth)
    LinearLayout ll_sixth;

    @BindView(R.id.ll_sixth_sub)
    LinearLayout ll_sixth_sub;

    @BindView(R.id.iv_penalty_switch)
    ImageView iv_penalty_switch;

    @BindView(R.id.ll_penalty_1)
    LinearLayout ll_penalty_1;

    @BindView(R.id.iv_penalty_1)
    ImageView iv_penalty_1;

    @BindView(R.id.ll_penalty_2)
    LinearLayout ll_penalty_2;

    @BindView(R.id.iv_penalty_2)
    ImageView iv_penalty_2;

    @BindView(R.id.ll_penalty_3)
    LinearLayout ll_penalty_3;

    @BindView(R.id.iv_penalty_3)
    ImageView iv_penalty_3;

    @BindView(R.id.ll_penalty_4)
    LinearLayout ll_penalty_4;

    @BindView(R.id.iv_penalty_4)
    ImageView iv_penalty_4;

    @BindView(R.id.mv_double)
    MessageView mv_double;

    @BindView(R.id.mv_bonus)
    MessageView mv_bonus;

    @BindView(R.id.mv_oecd)
    MessageView mv_oecd;

    @BindView(R.id.mv_penalty)
    MessageView mv_penalty;

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
    private String mSelectedSocre = "";

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

        ll_wheel.setVisibility(View.GONE);

        setGameOption();
    }

    @Override
    protected void attachEvents() {
        ll_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        ll_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        ll_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        ll_fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        ll_fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        ll_sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.performClick();
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv_double.setVisibility(View.GONE);
                mv_bonus.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
        });

        ll_double_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDoubleBtn(1);
            }
        });

        ll_double_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDoubleBtn(2);
            }
        });

        ll_double_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDoubleBtn(3);
            }
        });

        ll_double_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDoubleBtn(4);
            }
        });

        ll_double_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDoubleBtn(5);
            }
        });

        ll_double_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDoubleBtn(6);
            }
        });

        ll_bonus_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBonusBtn(1);
            }
        });

        ll_bonus_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBonusBtn(2);
            }
        });

        ll_bonus_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBonusBtn(3);
            }
        });

        ll_bonus_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBonusBtn(4);
            }
        });

        ll_bonus_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBonusBtn(5);
            }
        });

        ll_oecd_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOecdBtn(1);
            }
        });

        ll_oecd_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOecdBtn(2);
            }
        });

        ll_oecd_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOecdBtn(3);
            }
        });

        ll_oecd_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOecdBtn(4);
            }
        });

        ll_oecd_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOecdBtn(5);
            }
        });

        ll_oecd_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOecdBtn(6);
            }
        });

        ll_oecd_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOecdBtn(7);
            }
        });

        ll_penalty_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPenaltyBtn(1);
            }
        });

        ll_penalty_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPenaltyBtn(2);
            }
        });

        ll_penalty_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPenaltyBtn(3);
            }
        });

        ll_penalty_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPenaltyBtn(4);
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

    @OnClick(R.id.ll_per_hole_amount)
    void onClickAmount() {
        initWheel();

        main_wheel_center.setData(mBetArr);
    }

    @OnClick(R.id.iv_double_switch)
    void onClickDoubleSwitch() {
        if (ll_third_sub.isShown()) {
            iv_double_switch.setImageResource(R.drawable.switch_off);
            ll_third_sub.setVisibility(View.GONE);
        } else {
            iv_double_switch.setImageResource(R.drawable.switch_on);
            ll_third_sub.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.iv_bonus_switch)
    void onClickBonusSwitch() {
        if (ll_fourth_sub.isShown()) {
            iv_bonus_switch.setImageResource(R.drawable.switch_off);
            ll_fourth_sub.setVisibility(View.GONE);
        } else {
            iv_bonus_switch.setImageResource(R.drawable.switch_on);
            ll_fourth_sub.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.iv_oecd_switch)
    void onClikcOecdSwitch() {
        if (ll_fifth_sub.isShown()) {
            iv_oecd_switch.setImageResource(R.drawable.switch_off);
            ll_fifth_sub.setVisibility(View.GONE);
        } else {
            iv_oecd_switch.setImageResource(R.drawable.switch_on);
            ll_fifth_sub.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.iv_penalty_switch)
    void onClickPenaltySwitch() {
        if (ll_sixth_sub.isShown()) {
            iv_penalty_switch.setImageResource(R.drawable.switch_off);
            ll_sixth_sub.setVisibility(View.GONE);
        } else {
            iv_penalty_switch.setImageResource(R.drawable.switch_on);
            ll_sixth_sub.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.cv_confirm)
    void onClickConfirm() {
        Bundle bu = new Bundle();
        callActivity(SettingRounderActivity.class, bu,false);
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

    private void setGameOption() {
        if ("skins".equals(mGameType))
        {
            if ("skins".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_penalty.setVisibility(View.GONE);
            }
            else if ("jopok_skins".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("ggol_skins".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("hussein".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_penalty.setVisibility(View.GONE);
            }
            else if ("lasvagas".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_penalty.setVisibility(View.GONE);
            }
            else if ("new_lasvagas".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_penalty.setVisibility(View.GONE);
            }
            else if ("against".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
            else if ("nassau".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_sixth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
        }
        else if ("stroke".equals(mGameType))
        {
            if ("stroke".equals(mGameSubType))
            {
                ll_first_desc.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_sixth.setVisibility(View.GONE);

                mv_penalty.setVisibility(View.GONE);
            }
            else if ("scratch".equals(mGameSubType))
            {
                ll_first_desc.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_sixth.setVisibility(View.GONE);

                mv_penalty.setVisibility(View.GONE);
            }
            else if ("onebest".equals(mGameSubType))
            {
                ll_first_desc.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("team_stroke".equals(mGameSubType))
            {
                ll_first_desc.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("team_scratch".equals(mGameSubType))
            {
                ll_first_desc.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("random_scratch".equals(mGameSubType))
            {
                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("honest".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_156));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_18_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_third.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_double.setVisibility(View.GONE);
                mv_penalty.setVisibility(View.GONE);
            }
        }
        else if ("match".equals(mGameType))
        {
            if ("fourball_best".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_157));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("fourball_stroke".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_157));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("threeball_best".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_157));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("threeball_stroke".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_157));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("foursome".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_157));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("threesome".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_157));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
            }
            else if ("foursome_scramble".equals(mGameSubType))
            {
                tv_first_desc.setText(getResources().getString(R.string.ss_string_157));

                ll_amount.setVisibility(View.GONE);
                ll_9_prize.setVisibility(View.GONE);
                ll_diff_hole_amount.setVisibility(View.GONE);
                ll_18_diff_hole_amount.setVisibility(View.GONE);
                ll_per_hole_amount.setVisibility(View.GONE);

                ll_second.setVisibility(View.GONE);
                ll_fifth.setVisibility(View.GONE);

                mv_oecd.setVisibility(View.GONE);
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

    private void setDoubleBtn(int type) { //6
        if (1 == type)
        {
            iv_double_1.setImageResource(R.drawable.btn_check_on);
            iv_double_2.setImageResource(R.drawable.btn_check_off);
            iv_double_3.setImageResource(R.drawable.btn_check_off);
            iv_double_4.setImageResource(R.drawable.btn_check_off);
            iv_double_5.setImageResource(R.drawable.btn_check_off);
            iv_double_6.setImageResource(R.drawable.btn_check_off);
        }
        else if (2 == type)
        {
            iv_double_1.setImageResource(R.drawable.btn_check_off);
            iv_double_2.setImageResource(R.drawable.btn_check_on);
            iv_double_3.setImageResource(R.drawable.btn_check_off);
            iv_double_4.setImageResource(R.drawable.btn_check_off);
            iv_double_5.setImageResource(R.drawable.btn_check_off);
            iv_double_6.setImageResource(R.drawable.btn_check_off);
        }
        else if (3 == type)
        {
            iv_double_1.setImageResource(R.drawable.btn_check_off);
            iv_double_2.setImageResource(R.drawable.btn_check_off);
            iv_double_3.setImageResource(R.drawable.btn_check_on);
            iv_double_4.setImageResource(R.drawable.btn_check_off);
            iv_double_5.setImageResource(R.drawable.btn_check_off);
            iv_double_6.setImageResource(R.drawable.btn_check_off);
        }
        else if (4 == type)
        {
            iv_double_1.setImageResource(R.drawable.btn_check_off);
            iv_double_2.setImageResource(R.drawable.btn_check_off);
            iv_double_3.setImageResource(R.drawable.btn_check_off);
            iv_double_4.setImageResource(R.drawable.btn_check_on);
            iv_double_5.setImageResource(R.drawable.btn_check_off);
            iv_double_6.setImageResource(R.drawable.btn_check_off);
        }
        else if (5 == type)
        {
            iv_double_1.setImageResource(R.drawable.btn_check_off);
            iv_double_2.setImageResource(R.drawable.btn_check_off);
            iv_double_3.setImageResource(R.drawable.btn_check_off);
            iv_double_4.setImageResource(R.drawable.btn_check_off);
            iv_double_5.setImageResource(R.drawable.btn_check_on);
            iv_double_6.setImageResource(R.drawable.btn_check_off);
        }
        else if (6 == type)
        {
            iv_double_1.setImageResource(R.drawable.btn_check_off);
            iv_double_2.setImageResource(R.drawable.btn_check_off);
            iv_double_3.setImageResource(R.drawable.btn_check_off);
            iv_double_4.setImageResource(R.drawable.btn_check_off);
            iv_double_5.setImageResource(R.drawable.btn_check_off);
            iv_double_6.setImageResource(R.drawable.btn_check_on);
        }
    }

    private void setBonusBtn(int type) { //5
        if (1 == type)
        {
            iv_bonus_1.setImageResource(R.drawable.btn_check_on);
            iv_bonus_2.setImageResource(R.drawable.btn_check_off);
            iv_bonus_3.setImageResource(R.drawable.btn_check_off);
            iv_bonus_4.setImageResource(R.drawable.btn_check_off);
            iv_bonus_5.setImageResource(R.drawable.btn_check_off);
        }
        else if (2 == type)
        {
            iv_bonus_1.setImageResource(R.drawable.btn_check_off);
            iv_bonus_2.setImageResource(R.drawable.btn_check_on);
            iv_bonus_3.setImageResource(R.drawable.btn_check_off);
            iv_bonus_4.setImageResource(R.drawable.btn_check_off);
            iv_bonus_5.setImageResource(R.drawable.btn_check_off);
        }
        else if (3 == type)
        {
            iv_bonus_1.setImageResource(R.drawable.btn_check_off);
            iv_bonus_2.setImageResource(R.drawable.btn_check_off);
            iv_bonus_3.setImageResource(R.drawable.btn_check_on);
            iv_bonus_4.setImageResource(R.drawable.btn_check_off);
            iv_bonus_5.setImageResource(R.drawable.btn_check_off);
        }
        else if (4 == type)
        {
            iv_bonus_1.setImageResource(R.drawable.btn_check_off);
            iv_bonus_2.setImageResource(R.drawable.btn_check_off);
            iv_bonus_3.setImageResource(R.drawable.btn_check_off);
            iv_bonus_4.setImageResource(R.drawable.btn_check_on);
            iv_bonus_5.setImageResource(R.drawable.btn_check_off);
        }
        else if (5 == type)
        {
            iv_bonus_1.setImageResource(R.drawable.btn_check_off);
            iv_bonus_2.setImageResource(R.drawable.btn_check_off);
            iv_bonus_3.setImageResource(R.drawable.btn_check_off);
            iv_bonus_4.setImageResource(R.drawable.btn_check_off);
            iv_bonus_5.setImageResource(R.drawable.btn_check_on);
        }
    }

    private void setOecdBtn(int type) { //7
        if (1 == type)
        {
            iv_oecd_1.setImageResource(R.drawable.btn_check_on);
            iv_oecd_2.setImageResource(R.drawable.btn_check_off);
            iv_oecd_3.setImageResource(R.drawable.btn_check_off);
            iv_oecd_4.setImageResource(R.drawable.btn_check_off);
            iv_oecd_5.setImageResource(R.drawable.btn_check_off);
            iv_oecd_6.setImageResource(R.drawable.btn_check_off);
            iv_oecd_7.setImageResource(R.drawable.btn_check_off);
        }
        else if (2 == type)
        {
            iv_oecd_1.setImageResource(R.drawable.btn_check_off);
            iv_oecd_2.setImageResource(R.drawable.btn_check_on);
            iv_oecd_3.setImageResource(R.drawable.btn_check_off);
            iv_oecd_4.setImageResource(R.drawable.btn_check_off);
            iv_oecd_5.setImageResource(R.drawable.btn_check_off);
            iv_oecd_6.setImageResource(R.drawable.btn_check_off);
            iv_oecd_7.setImageResource(R.drawable.btn_check_off);
        }
        else if (3 == type)
        {
            iv_oecd_1.setImageResource(R.drawable.btn_check_off);
            iv_oecd_2.setImageResource(R.drawable.btn_check_off);
            iv_oecd_3.setImageResource(R.drawable.btn_check_on);
            iv_oecd_4.setImageResource(R.drawable.btn_check_off);
            iv_oecd_5.setImageResource(R.drawable.btn_check_off);
            iv_oecd_6.setImageResource(R.drawable.btn_check_off);
            iv_oecd_7.setImageResource(R.drawable.btn_check_off);
        }
        else if (4 == type)
        {
            iv_oecd_1.setImageResource(R.drawable.btn_check_off);
            iv_oecd_2.setImageResource(R.drawable.btn_check_off);
            iv_oecd_3.setImageResource(R.drawable.btn_check_off);
            iv_oecd_4.setImageResource(R.drawable.btn_check_on);
            iv_oecd_5.setImageResource(R.drawable.btn_check_off);
            iv_oecd_6.setImageResource(R.drawable.btn_check_off);
            iv_oecd_7.setImageResource(R.drawable.btn_check_off);
        }
        else if (5 == type)
        {
            iv_oecd_1.setImageResource(R.drawable.btn_check_off);
            iv_oecd_2.setImageResource(R.drawable.btn_check_off);
            iv_oecd_3.setImageResource(R.drawable.btn_check_off);
            iv_oecd_4.setImageResource(R.drawable.btn_check_off);
            iv_oecd_5.setImageResource(R.drawable.btn_check_on);
            iv_oecd_6.setImageResource(R.drawable.btn_check_off);
            iv_oecd_7.setImageResource(R.drawable.btn_check_off);
        }
        else if (6 == type)
        {
            iv_oecd_1.setImageResource(R.drawable.btn_check_off);
            iv_oecd_2.setImageResource(R.drawable.btn_check_off);
            iv_oecd_3.setImageResource(R.drawable.btn_check_off);
            iv_oecd_4.setImageResource(R.drawable.btn_check_off);
            iv_oecd_5.setImageResource(R.drawable.btn_check_off);
            iv_oecd_6.setImageResource(R.drawable.btn_check_on);
            iv_oecd_7.setImageResource(R.drawable.btn_check_off);
        }
        else if (7 == type)
        {
            iv_oecd_1.setImageResource(R.drawable.btn_check_off);
            iv_oecd_2.setImageResource(R.drawable.btn_check_off);
            iv_oecd_3.setImageResource(R.drawable.btn_check_off);
            iv_oecd_4.setImageResource(R.drawable.btn_check_off);
            iv_oecd_5.setImageResource(R.drawable.btn_check_off);
            iv_oecd_6.setImageResource(R.drawable.btn_check_off);
            iv_oecd_7.setImageResource(R.drawable.btn_check_on);
        }
    }

    private void setPenaltyBtn(int type) { //4
        if (1 == type)
        {
            iv_penalty_1.setImageResource(R.drawable.btn_check_on);
            iv_penalty_2.setImageResource(R.drawable.btn_check_off);
            iv_penalty_3.setImageResource(R.drawable.btn_check_off);
            iv_penalty_4.setImageResource(R.drawable.btn_check_off);
        }
        else if (2 == type)
        {
            iv_penalty_1.setImageResource(R.drawable.btn_check_off);
            iv_penalty_2.setImageResource(R.drawable.btn_check_on);
            iv_penalty_3.setImageResource(R.drawable.btn_check_off);
            iv_penalty_4.setImageResource(R.drawable.btn_check_off);
        }
        else if (3 == type)
        {
            iv_penalty_1.setImageResource(R.drawable.btn_check_off);
            iv_penalty_2.setImageResource(R.drawable.btn_check_off);
            iv_penalty_3.setImageResource(R.drawable.btn_check_on);
            iv_penalty_4.setImageResource(R.drawable.btn_check_off);
        }
        else if (4 == type)
        {
            iv_penalty_1.setImageResource(R.drawable.btn_check_off);
            iv_penalty_2.setImageResource(R.drawable.btn_check_off);
            iv_penalty_3.setImageResource(R.drawable.btn_check_off);
            iv_penalty_4.setImageResource(R.drawable.btn_check_on);
        }
    }

    private void initWheel() {
        Typeface typeface = ResourcesCompat.getFont(mActivity, R.font.roboto_regular);
        float spTextSize = 20;
        float textSize = spTextSize * getResources().getDisplayMetrics().scaledDensity;

        main_wheel_center = new WheelPicker(getApplicationContext());
        main_wheel_center = (WheelPicker) findViewById(R.id.main_wheel_center);
        main_wheel_center.setSelectedItemPosition(0);
        main_wheel_center.setItemSpace(70);
        main_wheel_center.setTypeface(typeface);
        main_wheel_center.setOnItemSelectedListener(this);
    }

}
