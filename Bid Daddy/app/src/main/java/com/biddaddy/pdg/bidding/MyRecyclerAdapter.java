package com.biddaddy.pdg.bidding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hpuser on 02-06-2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    List<model> rows;
    Map<String,Integer> image;


    //int[] image= {R.drawable.abc,R.drawable.dp,R.drawable.bcd,R.drawable.bcd,R.drawable.def};

    public MyRecyclerAdapter(Context c,List<model> rows,Map<String,Integer> image ){

        this.c =c;
        this.rows = rows;
        this.image=image;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag1_model,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override       //Bind data to views;
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.itemname.setText(rows.get(position).getItemname());
        holder.price.setText("Base Value: $"+rows.get(position).getPrice());
        holder.img.setImageResource(image.get(rows.get(position).getId()));
        // holder.img.setImageResource(rows.get(position).getImage());
        //Glide.with(c).load(R.drawable.man).into(holder.img);
       // holder.unfollow.findViewById(R.id.unfollow_bt);


//        holder.zzz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(c,detail.class);
//                c.startActivity(i);
//            }
//        });

       holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnitemClick(View v, int pos) {
                Intent i =new Intent(c,detail.class);
                Bundle b=new Bundle();
                b.putString("name",rows.get(pos).getItemname());
                b.putString("curr_max",rows.get(pos).getCurrent_max());
                b.putString("des",rows.get(pos).getDes());
                b.putString("id",rows.get(pos).getId());
                b.putString("base",rows.get(pos).getPrice());
                i.putExtras(b);
                c.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return rows.size();
    }
}
