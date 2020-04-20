package com.charles.supershot.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.charles.supershot.ui.BaseActivity;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected View mRootView;
    public BaseFragment(){}

    /*public static BaseFragment newInstance(BaseActivity activity){
        BaseFragment fr = new BaseFragment();
        fr.mActivity = activity;
        return fr;
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getViewResourceId(), container, false);
        //findViews();
        //setInitialData();
        //attachEvents();
        //followingWorksAfterInflateView();
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity)getActivity();
        followingWorksAfterInflateView();

    }

    /**
     * onCreateView()다음에 수행할 작업을 진행하도록 구현
     */
    protected void followingWorksAfterInflateView(){

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

    public void toast(String txt){
        if(isAdded()) {
            mActivity.toast(txt);
        }
    }
    public void toastLong(String txt){
        if(isAdded()) {
            mActivity.toastLong(txt);
        }
    }
    /**
     * 각 요소의 click event를 처리하도록 구현.
     * @param view
     */
    public void performClick(View view){
        throw new IllegalStateException("This method must be implemented by subclass.");
    }

    /**
     * 생성시 최초로 데이터를 처리하도록 구현.
     */
    protected void setInitialData(){
        throw new IllegalStateException("This method must be implemented by subclass.");
    }

    public void showSpinner(){
        if(isAdded() && mActivity != null) {
            mActivity.showSpinner();
        }
    }

    /**
     * * 스피너 프로그레스 다이알로그를 숨깁니다.
     */
    public void closeSpinner(){
        if(isAdded() && mActivity != null) {
            mActivity.closeSpinner();
        }
    }

    /**
     * 새로운 데이터로 교체하도록 구현
     * @param params
     */
    public void setTargetData(Object...params){

    }

    /**
     * Each subclass return the own layout ID that make up their screens.
     * @return layout id.
     */
    protected int getLayoutId(){
        throw new IllegalStateException("This method body should be implemented by sub class.[getLayoutId()]");
    }

    /**
     * Returns the {@link View} on current screen.
     * @param viewResourceId view's id
     * @return View's sub class
     */
    public <T extends View> T getView(int viewResourceId){
        return mRootView.findViewById(viewResourceId);
    }
    /**
     * Fragment onCreateView()에서 사용할 layout id을 반환하도록 구현
     * @return
     */
    public int getViewResourceId(){
        return -1;
    }

    public void removeFrgament(){
        FragmentManager fm = mActivity.getSupportFragmentManager();
        if( fm != null ) {
            fm.beginTransaction().remove(this).commit();
        }
    }

    /**
     * Implement to handle event state when a click event occurs.
     * @param view
     */
    public void performFragmentClick(View view){
        throw new IllegalStateException("This method body should be implemented by sub class.[performClick()]");
    }


    /**
     * Implement to handle event state when a click event occurs.
     * @param view
     * @param position the view position occurred event
     */
    public void performFragmentClick(View view, int position){
        throw new IllegalStateException("This method body should be implemented by sub class.[performClick()]");
    }

}
