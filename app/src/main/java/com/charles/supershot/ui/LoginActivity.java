package com.charles.supershot.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.charles.supershot.R;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.com_kakao_login)
    LoginButton com_kakao_login;

    @BindView(R.id.iv_kakao)
    ImageView iv_kakao;

    private SessionCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        findViews();
        attachEvents();
    }

    @Override
    protected void findViews() {
        // 카카오 로그인 초기화
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
    }

    @Override
    protected void attachEvents() {
        iv_kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*callback = new SessionCallback();
                Session session = Session.getCurrentSession();
                Session.getCurrentSession().addCallback(callback);
                session.open(AuthType.KAKAO_LOGIN_ALL, LoginActivity.this);*/
                com_kakao_login.performClick();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            // 카카오톡
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    protected void redirectLoginActivity() {
        //final Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
        //finish();
        toast("onSessionClosed");
    }

    // 카카오톡
    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {
            List<String> keys = new ArrayList<>();
            keys.add("properties.nickname");
            keys.add("properties.profile_image");
            keys.add("kakao_account.email");

            UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
                @Override
                public void onFailure(ErrorResult errorResult) {
                    String message = "failed to get user info. msg=" + errorResult;
                    Logger.d(message);
                    toast(message);
                }

                @Override
                public void onSessionClosed(ErrorResult errorResult) {
                    redirectLoginActivity();
                }

                @Override
                public void onSuccess(MeV2Response response) {
                /*Logger.d("user id : " + response.getId());
                Logger.d("email: " + response.getKakaoAccount().getEmail());
                Logger.d("profile image: " + response.getKakaoAccount()
                        .getProfileImagePath());
                redirectMainActivity();*/
                    try {
                        Long l_id = response.getId();
                        //toast(l_id + "");
                        if (null == response) {
                            //toast("1");
                        } else if (null == l_id) {
                            //toast("2");
                        } else if (null == response.getNickname()) {
                            //toast("3");
                        } else if (null == response.getKakaoAccount().getEmail()) {
                            //toast("4");
                            //toast("카카오에서 획득한 정보가 부족하여, 로그인할 수 없습니다.");
                        } else {
                            String openid = String.valueOf(response.getId());
                            String nickname = response.getNickname();
                            String email = response.getKakaoAccount().getEmail();

                            //toast(openid + "_____" + nickname + "_____" + email);

                            callActivity(JoinPersonalActivity.class, true);

                            //tryKakaoLogin(openid, email, nickname);
                        }
                    } catch (Exception ex) {
                        toast("카카오에서 획득한 정보가 부족하여, 로그인할 수 없습니다.");

                    }
                }

            /*@Override
            public void onNotSignedUp() {
                showSignup();
            }*/
            });
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if (exception != null) {
                Logger.e(exception);
                toast(exception.toString());
            }
        }
    }
}
