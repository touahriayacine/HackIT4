package com.example.hackit3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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
    RelativeLayout inc_price;
    RelativeLayout dec_price;
    float price_to_pay = 200.00F;
    float max_unit_price = 200.3F;
    float max_liters = 100;
    float total_balance = 4500.0F;
    TextView cash_availabale ;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fuels.add("Normal Gasoline");
        fuels.add("Premium Gasoline");
        fuels.add("Premium Unleaded Gasoline");
        fuels.add("Diesel fuel");
        fuels.add("LPG/C");
        prices.add( 100.15F);
        prices.add( 100.2F);
        prices.add( 100.05F);
        prices.add( 100.10F);
        prices.add( 200.3F);
        setContentView(R.layout.activity_offer);
        Intent i = getIntent();
        phoneNumber  = i.getStringExtra("phone_number");
        email = i.getStringExtra("email");
        rv = (RecyclerView) findViewById(R.id.recycler_view);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyAdapter mAdapter = new MyAdapter(fuels , prices , this);
        rv.setAdapter(mAdapter);
        inc_price = (RelativeLayout) findViewById(R.id.up_button);
        dec_price = (RelativeLayout) findViewById(R.id.down_button);
        confBtn(inc_price , 100.00F);
        confBtn(dec_price , -100.00F);
        cash_availabale = (TextView) findViewById(R.id.cash_available);
        cash_availabale.setText(((Float)total_balance).toString());
        ll = (LinearLayout) findViewById(R.id.pay_bills_btn);
        configWTB(ll , this);
    }
    public void configWTB(LinearLayout ll , OffersActivity c ){
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c, chooseWyToPay.class);
                i.putExtra("price_to_pay" , c.price_to_pay);
                i.putExtra("fuel_type" , c.fuels.get(c.selected));
                startActivity(i);
            }
        });
    }
    public void confBtn(RelativeLayout btn , float val ){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.price);
                OffersActivity c = ((OffersActivity)view.getContext());
                if(c.price_to_pay + val > 200.0 && ((c.price_to_pay + val) < c.max_liters * c.max_unit_price))  c.price_to_pay += val;
                tv.setText(((Float)c.price_to_pay).toString()+" DA");

                // le littrage:
                float unit_price = c.prices.get(c.selected);
                float liters = c.price_to_pay / unit_price;
                ProgressBar pb = (ProgressBar) findViewById(R.id.progress_horizontal);
                pb.setProgress((int)(liters / c.max_liters * 100));
            }
        });
    }
}