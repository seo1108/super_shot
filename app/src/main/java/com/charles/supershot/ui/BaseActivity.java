package com.charles.supershot.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.charles.supershot.R;
import com.charles.supershot.ui.dialog.ProgressSpinnerDialog;
import com.google.android.material.snackbar.Snackbar;

public class BaseActivity  extends AppCompatActivity {
    protected Dialog mSpinnerDialog;
    protected View mContentRootView;

    //public setPermissionListener permissionListener;
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //app =  getApplication() ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (snackbar != null && snackbar.isShown()) snackbar.dismiss();
    }


    /**
     * 뷰 구성요소를 추출 하도록 구현합니다.
     */
    protected void findViews(){
        throw new IllegalStateException("This method must be implemented by subclass.");
    }

    /**
     * 뷰 구성요소에 이벤트를 할당 하도록 구현합니다.
     */
    protected void attachEvents(){
        throw new IllegalStateException("This method must be implemented by subclass.");
    }

    protected <T extends View> T getView(int id){
        return findViewById(id);
    }

    public void callActivity(Class<?> clz, @Nullable Bundle bundle){
        callActivity(clz, bundle, false);
    }

    /**
     * Activiy를 시작합니다.
     * @param clz Activity class
     * @param finishCaller 호출한 Activity를 종료할지 여부
     */
    public void callActivity(Class<?> clz, boolean finishCaller){
        callActivity(clz, null, finishCaller);
    }

    /**
     * Activiy를 시작합니다.
     * @param clz Activity class
     * @param bundle Activity를 호출할 때 넘겨줄 데이터
     * @param finishCaller 호출한 Activity를 종료할지 여부
     */
    public void callActivity(Class<?> clz, @Nullable Bundle bundle, boolean finishCaller){
        Intent it = new Intent(getBaseContext(), clz);
        if( bundle != null ){
            it.putExtras(bundle);
        }
        startActivity(it);
        overridePendingTransition(R.anim.slide_in_right, R.anim.fade_out_half);
        if(finishCaller){
            finish();
            //overridePendingTransition(0,0);
        }
    }

    public void callActivityNoEffect(Class<?> clz, boolean finishCaller){
        callActivityNoEffect(clz, null, finishCaller);
    }

    public void callActivityNoEffect(Class<?> clz, @Nullable Bundle bundle, boolean finishCaller){
        Intent it = new Intent(getBaseContext(), clz);
        if( bundle != null ){
            it.putExtras(bundle);
        }
        startActivity(it);
        overridePendingTransition(0, 0);

        if(finishCaller){
            finish();
            overridePendingTransition(0,0);
        }
    }

    public void callActivityClearTask(Class<?> clz, @Nullable Bundle bundle, boolean finishCaller){
        Intent it = new Intent(getBaseContext(), clz);
        if( bundle != null ){
            it.putExtras(bundle);
        }
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(it);
        overridePendingTransition(R.anim.slide_in_right, R.anim.fade_out_half);
        if(finishCaller){
            finish();
            //overridePendingTransition(0,0);
        }
    }


    public void callActivity(Intent intent, boolean finishCaller){
        startActivity(intent);
        //overridePendingTransition(R.anim.slide_in_right, 0);
        if(finishCaller){
            finish();
            //overridePendingTransition(0, 0);
        }
    }

    public void toast(int id){
        toast(getString(id));
    }
    public void toast(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }
    public void toastLong(int id){
        toastLong(getString(id));
    }
    public void toastLong(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void showSpinner() {
        if(!isFinishing()) {
            if (mSpinnerDialog != null) {
                mSpinnerDialog.dismiss();
            }
            mSpinnerDialog = new ProgressSpinnerDialog(this, "");
            mSpinnerDialog.setCancelable(false);
            mSpinnerDialog.setCanceledOnTouchOutside(false);
            mSpinnerDialog.show();
        }
    }

    public void closeSpinner() {
        if(!isFinishing()) {
            if (mSpinnerDialog != null) {
                mSpinnerDialog.dismiss();
            }
            mSpinnerDialog = null;
        }
    }
}

