package com.example.hackit3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button enterBtn;
    EditText phoneNumberEdit;
    EditText emailEdit;
    String phoneNumber = "";
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBtn = (Button) findViewById(R.id.enter_button);
        phoneNumberEdit = (EditText) findViewById(R.id.phone_number);
        emailEdit = (EditText) findViewById(R.id.email);
        configBtn(this);
    }


    void configBtn(Context c) {
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c, OffersActivity.class);
                phoneNumber = phoneNumberEdit.getText().toString();
                i.putExtra("phone_number", phoneNumber);
                email = emailEdit.getText().toString();
                i.putExtra("email" , email);
                startActivity(i);
            }
        });
    }
}