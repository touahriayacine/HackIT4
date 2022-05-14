package com.example.hackit3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class chooseWyToPay extends AppCompatActivity {
    String price_to_pay;
    String fuel_type;
    Bu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_wy_to_pay);

        Intent i = getIntent();
        price_to_pay = i.getStringExtra("price_to_pay");
        fuel_type = i.getStringExtra("fuel_type");
    }
}