package com.example.hackit3;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class CustomDialog extends Dialog implements View.OnClickListener {
    public Activity c;
    public Dialog d;
    public ImageButton close;

    public CustomDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qr_dialog);
        close = (ImageButton) findViewById(R.id.close_qr);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_qr:
                c.finish();
                break;
            default:
                break;
        }
        dismiss();
    }
}
