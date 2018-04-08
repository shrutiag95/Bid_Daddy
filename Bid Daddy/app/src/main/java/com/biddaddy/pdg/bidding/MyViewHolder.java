package com.biddaddy.pdg.bidding;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 * Created by hpuser on 02-06-2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {

    ImageView img; TextView itemname;  RelativeLayout zzz; TextView price;
    ItemClickListener itemClickListener;


    public MyViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
        zzz = (RelativeLayout) itemView.findViewById(R.id.zzz);
        img =(ImageView)zzz.findViewById(R.id.item_img);
        itemname = (TextView)zzz.findViewById(R.id.item_name);
        price=(TextView)zzz.findViewById(R.id.bid);



    }

            @Override
            public void onClick(View v) {
                this.itemClickListener.OnitemClick(v,getAdapterPosition());
            }


           public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }
//
//    @Override
//    public void onClick(View v) {
//        this.itemClickListener.OnitemClick(v,getLayoutPosition());
//    }
}
