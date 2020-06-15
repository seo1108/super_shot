package com.charles.supershot.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.charles.supershot.R;

public class RowRounder extends LinearLayout {
    Context mContext;

    public RowRounder(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public RowRounder(Context context) {
        super(context);
        mContext = context;
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.row_rounder, this, true);
    }
}

