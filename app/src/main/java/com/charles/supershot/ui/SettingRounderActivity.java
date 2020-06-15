package com.charles.supershot.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.charles.supershot.R;
import com.charles.supershot.rest.DefaultRestClient;
import com.charles.supershot.rest.api.UserService;
import com.charles.supershot.rest.model.User;
import com.charles.supershot.rest.model.UserInfo;
import com.charles.supershot.ui.adapter.RowRounder;
import com.charles.supershot.utils.LogUtils;

import androidx.cardview.widget.CardView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingRounderActivity extends BaseActivity {
    private static final String TAG = SettingRounderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_rounder);


        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        getMyInfo();
    }

    @Override
    protected void attachEvents() {
    }

    void getMyInfo(){
        showSpinner();

        SharedPreferences prefr = getApplicationContext().getSharedPreferences("token", MODE_PRIVATE);
        String token = prefr.getString("token", "");
        String userSeq = prefr.getString("userSeq", "");
        Log.d("BEARER_TOKEN", token);

        UserService service = new DefaultRestClient<UserService>(getBaseContext()).getClient(UserService.class);
        Call<UserInfo> call = service.userInfo(token, userSeq);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                LogUtils.err(TAG, response.raw().toString());

                Log.d(TAG, response.raw().toString());

                if (200 == response.raw().code())
                {
                    User user = response.body().getData();
                    RowRounder n_layout = new RowRounder(getApplicationContext());
                    LinearLayout con = (LinearLayout) findViewById(R.id.rounder_ll);
                    con.addView(n_layout);

                    CardView row = con.findViewById(R.id.box_of_row);
                    CircleImageView iv_profile = con.findViewById(R.id.iv_profile);
                    TextView tv_name = con.findViewById(R.id.tv_name);
                    TextView tv_score_number = con.findViewById(R.id.tv_score_number);
                    LinearLayout ll_handy = con.findViewById(R.id.ll_handy);
                    TextView tv_name_desc = con.findViewById(R.id.tv_name_desc);

                    Glide.with(getApplicationContext())
                            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQAxf_kMdZ91tOIpu23R83XOmjR14iXWnA_qf4U4TcBKD34-kOP&usqp=CAU")
                            .fitCenter()
                            .into(iv_profile);
                    tv_name.setText(user.getName());
                    tv_name_desc.setText(String.format(getResources().getString(R.string.ss_string_300), "0"));
                    tv_score_number.setText("72");
                    // box_of_row iv_profile tv_name tv_score_number tv_name_desc ll_handy
                }
                else
                {
                }
                closeSpinner();
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                closeSpinner();
                Log.d(TAG, t.toString());
            }

        });
    }
}