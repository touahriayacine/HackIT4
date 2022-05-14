package com.example.hackit3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class chooseWyToPay extends AppCompatActivity {
    String price_to_pay;
    String fuel_type;
    LinearLayout pay_QR_btn ;
    LinearLayout pay_Baridi_Mob_Btn;
    RelativeLayout back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_wy_to_pay);

        Intent i = getIntent();
        price_to_pay = i.getStringExtra("price_to_pay");
        fuel_type = i.getStringExtra("fuel_type");
        pay_QR_btn = (LinearLayout) findViewById(R.id.pay_with_QR);
        pay_Baridi_Mob_Btn = (LinearLayout) findViewById(R.id.pay_with_baridi);
        back_btn = (RelativeLayout) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext() , OffersActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        pay_QR_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog cd = new CustomDialog((chooseWyToPay)view.getContext());
                cd.show();
            }
        });

     }
}