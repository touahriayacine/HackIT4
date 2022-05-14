package com.example.hackit3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<String> fuels ;
    Context c;
    ArrayList<Float> prices;
    public MyAdapter(ArrayList<String> fuels  , ArrayList<Float> prices, Context c){
        this.fuels = fuels;
        this.c = c;
        this.prices = prices;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_fuel_type ,parent,false);
        MyViewHolder holder =  new MyViewHolder(view) ;
        return holder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name_fuel.setText(fuels.get(position));
        holder.price_fuel.setText(prices.get(position) + " DA/L");
        if(position == ((OffersActivity) this.c).selected){
            holder.name_fuel.setTextColor(Color.parseColor("#2E3192"));
            holder.ring.setBackground(this.c.getResources().getDrawable(R.drawable.ring_blue));
            holder.style.setBackground(this.c.getResources().getDrawable(R.drawable.selected_card));
            holder.price_fuel.setTextColor(Color.parseColor("#FFDC00"));
        }else {
            holder.name_fuel.setTextColor(Color.parseColor("#A7A6A6"));
            holder.ring.setBackground(this.c.getResources().getDrawable(R.drawable.ring_grey));
            holder.style.setBackground(this.c.getResources().getDrawable(R.drawable.unselected_card));
            holder.price_fuel.setTextColor(Color.parseColor("#A7A6A6"));
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OffersActivity c = ((OffersActivity)view.getContext());
                c.selected = position;
                holder.name_fuel.setTextColor(Color.parseColor("#2E3192"));
                holder.ring.setBackground(c.getResources().getDrawable(R.drawable.ring_blue));
                holder.style.setBackground(c.getResources().getDrawable(R.drawable.selected_card));
                holder.price_fuel.setTextColor(Color.parseColor("#FFDC00"));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fuels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name_fuel ;
        TextView price_fuel;
        RelativeLayout ring;
        RelativeLayout style;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_fuel = itemView.findViewById(R.id.fuel_type);
            price_fuel =itemView.findViewById(R.id.fuel_price);
            ring = itemView.findViewById(R.id.ring1);
            style = itemView.findViewById(R.id.style_background);
            cardView = itemView.findViewById(R.id.type1);
        }
    }
}
