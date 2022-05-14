package com.example.hackit3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {
    String phoneNumber ="";
    String email = "";
    RecyclerView rv;
    RecyclerView.LayoutManager lm ;
    ArrayList<String> fuels =new ArrayList<>();
    ArrayList<Float> prices = new ArrayList<>();
    public int selected = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fuels.add("Normal Gasoline");
        fuels.add("Premium Gasoline");
        fuels.add("Premium Unleaded Gasoline");
        fuels.add("Diesel fuel");
        fuels.add("LPG/C");
        prices.add((float) 1.15);
        prices.add((float) 1.15);
        prices.add((float) 1.15);
        prices.add((float) 1.15);
        prices.add((float) 1.15);
        setContentView(R.layout.activity_offer);
        Intent i = getIntent();
        phoneNumber  = i.getStringExtra("phone_number");
        email = i.getStringExtra("email");
        rv = (RecyclerView) findViewById(R.id.recycler_view);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyAdapter mAdapter = new MyAdapter(fuels , prices , this);
        rv.setAdapter(mAdapter);
    }
}