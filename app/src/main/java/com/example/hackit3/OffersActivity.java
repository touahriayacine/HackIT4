package com.example.hackit3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class OffersActivity extends AppCompatActivity {
    String phoneNumber ="";
    String email = "";
    TextView phoneNumberText;
    TextView emailText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        Intent i = getIntent();
        phoneNumber  = i.getStringExtra("phone_number");
        email = i.getStringExtra("email");
        phoneNumberText = (TextView) findViewById(R.id.phone_number_txt);
        emailText = (TextView) findViewById(R.id.email_txt);
        phoneNumberText.setText(phoneNumber);
        emailText.setText(email);
    }
}