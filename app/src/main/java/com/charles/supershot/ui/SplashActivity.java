package com.charles.supershot.ui;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;

import com.charles.supershot.R;
import com.charles.supershot.rest.DefaultRestClient;
import com.charles.supershot.rest.api.AuthService;
import com.charles.supershot.rest.model.UserData;
import com.charles.supershot.utils.LogUtils;

import java.security.MessageDigest;
import java.util.HashMap;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends BaseActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        findViews();
        getAppKeyHash();
    }

    @Override
    protected  void findViews() {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                // 다음화면으로 이동
                //callActivity(LoginActivity.class, true);
                //callActivity(JoinCompanyActivity.class, true);


                signinWithSNS();
            }
        }, 1000);
    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));

                Log.d("[KEYHASH]", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
    }

    private void signinWithSNS() {
        showSpinner();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("sns", MODE_PRIVATE);

        /************************
         *
         * 임시
         *
         ***********************/
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("snsId", "1322456930");
        editor.putString("snsType", "kakao");
        editor.commit();
        /************************
         *
         * 임시
         *
        ***********************/

        if ("".equals(pref.getString("snsId", ""))) {
            callActivity(JoinPersonalActivity.class, true);
            return;
        }

        HashMap<String, Object> query = new HashMap<>();
        query.put("snsId", pref.getString("snsId", ""));
        query.put("snsType", pref.getString("snsType", ""));

        AuthService service =
                new DefaultRestClient<AuthService>(getBaseContext())
                        .getClient(AuthService.class);
        Call<UserData> call = service.signinWithSNS(query);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                LogUtils.err(TAG, response.raw().toString());

                Log.d(TAG, response.raw().toString());
                if (200 == response.raw().code()) {
                    // 사용 가능
                    UserData data = response.body();
                    Log.d("SSSSSSSSSSSSSSSSSSSS", data.getStatusCode() + "__" + data.getMessage());
                    Log.d("SSSSSSSSSSSSSSSSSSSS", data.getData().getUser().getGender());
                    Log.d("SSSSSSSSSSSSSSSSSSSS", data.getData().getUser().getUserId());
                    Log.d("SSSSSSSSSSSSSSSSSSSS", data.getData().getUser().getUserSeq());
                    Log.d("SSSSSSSSSSSSSSSSSSSS", data.getData().getToken());

                    SharedPreferences prefr = getApplicationContext().getSharedPreferences("token", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefr.edit();
                    editor.putString("token", data.getData().getToken());
                    editor.putString("userSeq", data.getData().getUser().getUserSeq());
                    editor.commit();

                    Log.d("TOKEN", data.getData().getToken());

                    callActivity(GameTypeActivity.class, true);

                } else {
                    // 사용 불가
                    callActivity(JoinPersonalActivity.class, true);
                }

                closeSpinner();
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                closeSpinner();
                Log.d(TAG, t.toString());
            }
        });

        closeSpinner();
    }
}