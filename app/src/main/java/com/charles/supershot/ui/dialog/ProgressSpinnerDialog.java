package com.charles.supershot.ui.dialog;

import android.os.Bundle;

import com.charles.supershot.R;
import com.charles.supershot.ui.BaseActivity;

public class ProgressSpinnerDialog extends BaseDialog {
    private String mMessage;

    public ProgressSpinnerDialog(BaseActivity context, String msg){
        super(context, R.style.custom_dialog_style);
        mMessage = msg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_spinner);
    }
}
