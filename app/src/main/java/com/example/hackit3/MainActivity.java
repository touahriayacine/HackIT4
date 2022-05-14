package com.example.hackit3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout login;
    EditText phoneNumberEdit;
    String phoneNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (LinearLayout) findViewById(R.id.login);
        phoneNumberEdit = (EditText) findViewById(R.id.phone_number);
        configBtn(this);
    }


    void configBtn(Context c) {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c, OffersActivity.class);
                phoneNumber = phoneNumberEdit.getText().toString();
                i.putExtra("phone_number", phoneNumber);
                startActivity(i);
            }
        });
    }
}