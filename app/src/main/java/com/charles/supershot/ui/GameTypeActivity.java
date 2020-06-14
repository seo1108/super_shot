package com.charles.supershot.ui;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
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

    @BindView(R.id.tv_desc1)
    TextView tv_desc1;

    @BindView(R.id.tv_desc2)
    TextView tv_desc2;

    @BindView(R.id.ll_skins)
    LinearLayout ll_skins;

    @BindView(R.id.tv_skins)
    TextView tv_skins;

    @BindView(R.id.ll_stroke)
    LinearLayout ll_stroke;

    @BindView(R.id.tv_stroke)
    TextView tv_stroke;

    @BindView(R.id.ll_match)
    LinearLayout ll_match;

    @BindView(R.id.tv_match)
    TextView tv_match;

    @BindView(R.id.ll_myeongrang)
    LinearLayout ll_myeongrang;

    @BindView(R.id.tv_myeongrang)
    TextView tv_myeongrang;

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

    private List<String> mEmptyArr = new ArrayList<>();

    private String[] mGameArray;
    private List<String> mArr;

    private String[] mSkinsArray;
    private List<String> mSkinsArr;

    private String[] mStrokeArray;
    private List<String> mStrokeArr;

    private String[] mMatchArray;
    private List<String> mMatchArr;

    private String[] mMyeongArray;
    private List<String> mMyeongArr;


    private String mSelectedText = "";
    private String mSelectedGameType = "skins";
    private String mSelectedGameSubType = "";
    private int mType;

    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_game_type);
        ButterKnife.bind(this);

        mType = getIntent().getIntExtra("type", 1);



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

        mSkinsArray = getResources().getStringArray(R.array.skins);
        mSkinsArr = new ArrayList<>();

        for (int idx = 0; idx < mSkinsArray.length; idx++) {
            mSkinsArr.add(mSkinsArray[idx]);
        }

        mStrokeArray = getResources().getStringArray(R.array.strokes);
        mStrokeArr = new ArrayList<>();

        for (int idx = 0; idx < mStrokeArray.length; idx++) {
            mStrokeArr.add(mStrokeArray[idx]);
        }

        mMatchArray = getResources().getStringArray(R.array.match);
        mMatchArr = new ArrayList<>();

        for (int idx = 0; idx < mMatchArray.length; idx++) {
            mMatchArr.add(mMatchArray[idx]);
        }

        mMyeongArray = getResources().getStringArray(R.array.myeongrang);
        mMyeongArr = new ArrayList<>();

        for (int idx = 0; idx < mMyeongArray.length; idx++) {
            mMyeongArr.add(mMyeongArray[idx]);
        }


        setUI(1);

        ll_wheel.setVisibility(View.GONE);

        //main_wheel_center.setData(mSkinsArr);
        //main_wheel_center.setItemTextSize((int) textSize);

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

        ll_skins.setOnClickListener(v->{
            mSelectedText = "";
            setDescription();
            setUI(1);
        });

        ll_stroke.setOnClickListener(v->{
            mSelectedText = "";
            setDescription();
            setUI(2);
        });

        ll_match.setOnClickListener(v->{
            mSelectedText = "";
            setDescription();
            setUI(3);
        });

        ll_myeongrang.setOnClickListener(v->{
            mSelectedText = "";
            setDescription();
            setUI(4);
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
                Bundle bu = new Bundle();
                bu.putSerializable("gameType", mSelectedGameType);
                bu.putSerializable("gameSubType", mSelectedGameSubType);
                callActivity(GameOptionActivity.class, bu,false);
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

        setDescription();
    }

    private void setUI(int type) {
        initWheel();

        tv_skins.setTextColor(getResources().getColor(R.color.brownish_grey));
        ll_skins.setBackground(getResources().getDrawable(R.drawable.brownishgrey_r17));

        tv_stroke.setTextColor(getResources().getColor(R.color.brownish_grey));
        ll_stroke.setBackground(getResources().getDrawable(R.drawable.brownishgrey_r17));

        tv_match.setTextColor(getResources().getColor(R.color.brownish_grey));
        ll_match.setBackground(getResources().getDrawable(R.drawable.brownishgrey_r17));

        tv_myeongrang.setTextColor(getResources().getColor(R.color.brownish_grey));
        ll_myeongrang.setBackground(getResources().getDrawable(R.drawable.brownishgrey_r17));

        tv_game_type.setText("");
        //mSelectedText = "";

        Log.d("SSSSSSSSSSSSSSSSS", main_wheel_center.getCurrentItemPosition() + " 1");
        if (1 == type)
        {
            tv_skins.setTextColor(getResources().getColor(R.color.apple));
            ll_skins.setBackground(getResources().getDrawable(R.drawable.apple_r17));

            main_wheel_center.setData(mSkinsArr);
            main_wheel_center.setSelectedItemPosition(0);
            mSelectedGameType = "skins";
            mSelectedText = mSkinsArray[main_wheel_center.getCurrentItemPosition()];
        }
        else if (2 == type)
        {
            tv_stroke.setTextColor(getResources().getColor(R.color.apple));
            ll_stroke.setBackground(getResources().getDrawable(R.drawable.apple_r17));

            main_wheel_center.setData(mStrokeArr);
            main_wheel_center.setSelectedItemPosition(0);
            mSelectedGameType = "stroke";
            mSelectedText = mStrokeArray[main_wheel_center.getCurrentItemPosition()];
        }
        else if (3 == type)
        {
            tv_match.setTextColor(getResources().getColor(R.color.apple));
            ll_match.setBackground(getResources().getDrawable(R.drawable.apple_r17));

            main_wheel_center.setData(mMatchArr);
            main_wheel_center.setSelectedItemPosition(0);
            mSelectedGameType = "match";
            mSelectedText = mMatchArray[main_wheel_center.getCurrentItemPosition()];
        }
        else if (4 == type)
        {
            tv_myeongrang.setTextColor(getResources().getColor(R.color.apple));
            ll_myeongrang.setBackground(getResources().getDrawable(R.drawable.apple_r17));

            main_wheel_center.setData(mMyeongArr);
            main_wheel_center.setSelectedItemPosition(0);
            mSelectedGameType = "myeongrang";
            mSelectedText = mMyeongArray[main_wheel_center.getCurrentItemPosition()];
        }



        setDescription();

        /*cv_next.setVisibility(View.GONE);
        ll_wheel.setVisibility(View.VISIBLE);

        main_wheel_center.setItemSpace(80);
        main_wheel_center.setTypeface(typeface);
        main_wheel_center.setOnItemSelectedListener(this);*/
    }

    public void setDescription() {
        if ("skins".equals(mSelectedGameType))
        {
            if ("".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.ss_string_065));
                tv_desc2.setText(getResources().getString(R.string.ss_string_066));

                mSelectedGameSubType = "";
            }
            else if ("스킨스".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_skins));
                tv_desc2.setText(getResources().getString(R.string.skins_skins_desc));

                mSelectedGameSubType = "skins";
            }
            else if ("조폭 스킨스".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_jopok_skins));
                tv_desc2.setText(getResources().getString(R.string.skins_jopok_skins_desc));

                mSelectedGameSubType = "jopok_skins";
            }
            else if ("꼴등 스킨스".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_ggol_skins));
                tv_desc2.setText(getResources().getString(R.string.skins_ggol_skins_desc));

                mSelectedGameSubType = "ggol_skins";
            }
            else if ("후세인".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_hussein));
                tv_desc2.setText(getResources().getString(R.string.skins_hussein_desc));

                mSelectedGameSubType = "hussein";
            }
            else if ("라스베가스".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_lasvagas));
                tv_desc2.setText(getResources().getString(R.string.skins_lasvagas_desc));

                mSelectedGameSubType = "lasvagas";
            }
            else if ("신라스베가스(뽑기)".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_new_lasvagas));
                tv_desc2.setText(getResources().getString(R.string.skins_new_lasvagas_desc));

                mSelectedGameSubType = "new_lasvagas";
            }
            else if ("어게인스트".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_against));
                tv_desc2.setText(getResources().getString(R.string.skins_against_desc));

                mSelectedGameSubType = "against";
            }
            else if ("낫소".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.skins_nassau));
                tv_desc2.setText(getResources().getString(R.string.skins_nassau_desc));

                mSelectedGameSubType = "nassau";
            }

        }
        else if ("stroke".equals(mSelectedGameType))
        {
            if ("".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.ss_string_065));
                tv_desc2.setText(getResources().getString(R.string.ss_string_066));

                mSelectedGameSubType = "";
            }
            else if ("스트로크".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.strokes_stroke));
                tv_desc2.setText(getResources().getString(R.string.strokes_stroke_desc));

                mSelectedGameSubType = "stroke";
            }
            else if ("스크래치".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.strokes_scratch));
                tv_desc2.setText(getResources().getString(R.string.strokes_scratch_desc));

                mSelectedGameSubType = "scratch";
            }
            else if ("원베스트 스코어".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.strokes_onebest));
                tv_desc2.setText(getResources().getString(R.string.strokes_onebest_desc));

                mSelectedGameSubType = "onebest";
            }
            else if ("팀 스트로크".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.strokes_team_stroke));
                tv_desc2.setText(getResources().getString(R.string.strokes_team_stroke_desc));

                mSelectedGameSubType = "team_stroke";
            }
            else if ("팀 스크래치".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.strokes_team_scratch));
                tv_desc2.setText(getResources().getString(R.string.strokes_team_scratch_desc));

                mSelectedGameSubType = "team_scratch";
            }
            else if ("랜덤 스크래치".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.strokes_random_scratch));
                tv_desc2.setText(getResources().getString(R.string.strokes_random_scratch_desc));

                mSelectedGameSubType = "random_scratch";
            }
            else if ("어니스트존".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.strokes_honest));
                tv_desc2.setText(getResources().getString(R.string.strokes_honest_desc));

                mSelectedGameSubType = "honest";
            }
        }
        else if ("match".equals(mSelectedGameType))
        {
            if ("".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.ss_string_065));
                tv_desc2.setText(getResources().getString(R.string.ss_string_066));

                mSelectedGameSubType = "";
            }
            else if ("포볼(베스트볼)".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.match_fourball_best));
                tv_desc2.setText(getResources().getString(R.string.match_fourball_best_desc));

                mSelectedGameSubType = "fourball_best";
            }
            else if ("포볼(스트로크)".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.match_fourball_stroke));
                tv_desc2.setText(getResources().getString(R.string.match_fourball_stroke_desc));

                mSelectedGameSubType = "fourball_stroke";
            }
            else if ("쓰리볼(베스트볼)".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.match_threeball_best));
                tv_desc2.setText(getResources().getString(R.string.match_threeball_best_desc));

                mSelectedGameSubType = "threeball_best";
            }
            else if ("쓰리볼(스트로크)".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.match_threeball_stroke));
                tv_desc2.setText(getResources().getString(R.string.match_threeball_strole_desc));

                mSelectedGameSubType = "threeball_stroke";
            }
            else if ("포섬".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.match_foursome));
                tv_desc2.setText(getResources().getString(R.string.match_foursome_desc));

                mSelectedGameSubType = "foursome";
            }
            else if ("쓰리섬".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.match_threesome));
                tv_desc2.setText(getResources().getString(R.string.match_threesome_desc));

                mSelectedGameSubType = "threesome";
            }
            else if ("포섬 스크램블".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.match_foursome_scramble));
                tv_desc2.setText(getResources().getString(R.string.match_foursome_scramble_desc));

                mSelectedGameSubType = "foursome_scramble";
            }
        }
        else if ("myeongrang".equals(mSelectedGameType))
        {
            if ("".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.ss_string_065));
                tv_desc2.setText(getResources().getString(R.string.ss_string_066));

                mSelectedGameSubType = "";
            }
            else if ("스트로크".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_stroke));
                tv_desc2.setText(getResources().getString(R.string.myeong_stroke_desc));

                mSelectedGameSubType = "stroke";
            }
            else if ("스크래치".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_scratch));
                tv_desc2.setText(getResources().getString(R.string.myeong_scratch_desc));

                mSelectedGameSubType = "scratch";
            }
            else if ("팀 스트로크".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_team_stroke));
                tv_desc2.setText(getResources().getString(R.string.myeong_team_stroke_desc));

                mSelectedGameSubType = "team_stroke";
            }
            else if ("팀 스크래치".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_team_scratch));
                tv_desc2.setText(getResources().getString(R.string.myeong_team_scratch_desc));

                mSelectedGameSubType = "team_scratch";
            }
            else if ("랜덤 스크래치".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_random_scratch));
                tv_desc2.setText(getResources().getString(R.string.myeong_random_scratch_desc));

                mSelectedGameSubType = "random_scratch";
            }
            else if ("포볼(베스트볼)".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_fourball_best));
                tv_desc2.setText(getResources().getString(R.string.myeong_fourball_best_desc));

                mSelectedGameSubType = "fourball_best";
            }
            else if ("쓰리볼(베스트볼)".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_threeball_best));
                tv_desc2.setText(getResources().getString(R.string.myeong_threeball_best_desc));

                mSelectedGameSubType = "threeball_best";
            }
            else if ("포섬".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_foursome));
                tv_desc2.setText(getResources().getString(R.string.myeong_foursome_desc));

                mSelectedGameSubType = "foursome";
            }
            else if ("쓰리섬".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_threesome));
                tv_desc2.setText(getResources().getString(R.string.myeong_threesome_desc));

                mSelectedGameSubType = "threesome";
            }
            else if ("포섬 스크램블".equals(mSelectedText))
            {
                tv_desc1.setText(getResources().getString(R.string.myeong_foursome_scramble));
                tv_desc2.setText(getResources().getString(R.string.myeong_foursome_scramble_desc));

                mSelectedGameSubType = "foursome_scramble";
            }
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

