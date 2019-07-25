package com.example.infokavling.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infokavling.Interface.ItemClickListener;
import com.example.infokavling.R;


public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

{

    public TextView txtMenuName;
    public ImageView imageView;


        private ItemClickListener itemClickListener;


    public MenuViewHolder(View itemView) {
        super(itemView);

        txtMenuName = (TextView)itemView.findViewById(R.id.Menu_name);
        imageView =  (ImageView)itemView.findViewById(R.id.Menu_image);


        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;

    }





    @Override
    public void onClick(View view) {


        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}