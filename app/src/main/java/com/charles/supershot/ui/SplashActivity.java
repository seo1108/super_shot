package com.charles.supershot.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;

import com.charles.supershot.R;

import java.security.MessageDigest;

import butterknife.ButterKnife;

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
                callActivity(JoinPersonalActivity.class, true);
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
}